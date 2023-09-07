package com.codegik.poc.restserver.handler

import com.codegik.poc.restserver.annotation.Delete
import com.codegik.poc.restserver.annotation.Get
import com.codegik.poc.restserver.annotation.Post
import com.codegik.poc.restserver.model.Constants.Companion.PATH_VARIABLE_PATTERN
import com.codegik.poc.restserver.model.HttpResponse
import com.codegik.poc.restserver.server.PackageScanner


object RequestHandlerMapper {

    fun registerRequestHandlers(): RequestHandlerMap {
        val requestHandlerMap = RequestHandlerMap()

        PackageScanner().loadRestApiClasses().forEach { restApiClass ->
            val instance = restApiClass.constructors[0].newInstance()

            restApiClass.declaredMethods.forEach { method ->
                if (method.returnType != HttpResponse::class.java) {
                    println("Mapping method ${restApiClass.name}.${method.name} -> FAILED (doesn't return HttpResponse type)")
                } else {
                    method.annotations.forEach { annotation ->
                        val key = when (annotation) {
                            is Get      -> Pair("${Get::class.simpleName!!.uppercase()}", "${annotation.path}")
                            is Post     -> Pair("${Post::class.simpleName!!.uppercase()}", "${annotation.path}")
                            is Delete   -> Pair("${Delete::class.simpleName!!.uppercase()}", "${annotation.path}")
                            else        -> Pair("", "")
                        }

                        if (key.first.isEmpty()) {
                            println("Mapping endpoint $key -> FAILED ($annotation not supported)")
                        } else {
                            var cleanKey = key
                            while (cleanKey.second.last() == '/') {
                                cleanKey = Pair(key.first, cleanKey.second.dropLast(1))
                            }

                            val countParameters = PATH_VARIABLE_PATTERN.findAll(cleanKey.second).count()

                            if (annotation !is Post && countParameters != method.parameterCount) {
                                println("Mapping method ${restApiClass.name}.${method.name} -> FAILED " +
                                        "(path is expecting $countParameters parameters, " +
                                        "but found ${method.parameterCount} in method)")
                            } else if (requestHandlerMap.hasKey(cleanKey)) {
                                println("Mapping method ${restApiClass.name}.${method.name} -> FAILED (path is duplicated)")
                            } else {
                                requestHandlerMap.put(
                                    countParameters,
                                    cleanKey,
                                    HttpRequestHandler(instance, method)
                                )
                                println("Mapping endpoint $cleanKey -> ${restApiClass.name}.${method.name}")
                            }
                        }
                    }
                }
            }
        }

        return requestHandlerMap
    }
}