package com.codegik.poc.restserver.handler

import com.codegik.poc.restserver.annotation.Delete
import com.codegik.poc.restserver.annotation.Get
import com.codegik.poc.restserver.annotation.Post
import com.codegik.poc.restserver.model.HttpRequest
import com.codegik.poc.restserver.model.HttpResponse
import com.codegik.poc.restserver.model.PartitionedEndpointMap
import com.codegik.poc.restserver.server.PackageScanner


/**
 * TODO
 *  - do not allow duplicated endpoint mapping
 *  - do not map method with number of request param different than number of arguments
 *      - ex:
 *          @Get("/hello/{name}/{midName}/{lastNme}/my/friend")
 *          fun helloWithThreeRequestParamWithoutThreeParameters(name: String, nickname: String): HttpResponse
 */
object RequestHandlerFactory {

    private val scanner = PackageScanner()
    private val pathVariablePattern = """\{[^}]*\}""".toRegex()
    private val partitionedEndpointMap = registerEndpoints()


    private fun registerEndpoints(): PartitionedEndpointMap {
        val partitionedEndpointMap = PartitionedEndpointMap()

        scanner.loadRestApiClasses().forEach { restApiClass ->
            val instance = restApiClass.constructors[0].newInstance()

            restApiClass.declaredMethods.forEach { method ->
                if (method.returnType != HttpResponse::class.java) {
                    println("Mapping method ${restApiClass.name}.${method.name} -> FAILED (doesn't return HttpResponse type)")
                } else {
                    method.annotations.forEach { annotation ->
                        var key = when (annotation) {
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

                            val countParameters = pathVariablePattern.findAll(cleanKey.second).count()

                            partitionedEndpointMap.put(countParameters, cleanKey, HttpRequestHandler(instance, method))
                            println("Mapping endpoint $cleanKey -> ${restApiClass.name}.${method.name}")
                        }
                    }
                }
            }
        }

        return partitionedEndpointMap
    }


    fun getHttpRequestHandler(httpRequest: HttpRequest): RequestHandler {
        return partitionedEndpointMap.get(httpRequest);
    }

}