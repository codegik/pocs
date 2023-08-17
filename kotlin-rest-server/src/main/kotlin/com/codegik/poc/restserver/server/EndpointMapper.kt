package com.codegik.poc.restserver.server

import com.codegik.poc.restserver.annotation.Delete
import com.codegik.poc.restserver.annotation.Get
import com.codegik.poc.restserver.annotation.Post
import com.codegik.poc.restserver.annotation.RestApi
import com.codegik.poc.restserver.handler.HttpRequestHandler
import com.codegik.poc.restserver.model.HttpResponse
import java.io.File


object EndpointMapper {

    private val pathVariablePattern = """\{[^}]*\}""".toRegex()
    val mappedEndpoints = registerEndpoints().toMutableMap()
    val mappedMatchPatterns = registerMatchPatterns().toMutableMap()



    private fun registerEndpoints(): Map<Pair<String, String>, HttpRequestHandler> {
        val mappingEndpoints = mutableMapOf<Pair<String, String>, HttpRequestHandler>()

        loadRestApiClasses().forEach { restApiClass ->
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

                            mappingEndpoints[cleanKey] = HttpRequestHandler(instance, method)
                            println("Mapping endpoint $cleanKey -> ${restApiClass.name}.${method.name}")
                        }
                    }
                }
            }
        }

        return mappingEndpoints
    }


    private fun registerMatchPatterns(): Map<String, Regex> {
        val mappingMatchPattern = mutableMapOf<String, Regex>()

        mappedEndpoints.forEach { (key, pair) ->
            if (key.second.contains("{")) {
                var endpointPattern = key.second.replace("/", "\\/")

                pathVariablePattern.findAll(key.second).forEach { variable ->
                    endpointPattern = endpointPattern.replace(variable.value, "[a-zA-Z0-9%]+")
                }

                mappingMatchPattern[key.second] = "$endpointPattern$".toRegex()
            }
        }

        return mappingMatchPattern
    }


    private fun loadRestApiClasses(): List<Class<*>> {
        val packageName = "com.codegik.poc.restserver"
        val classLoader = Thread.currentThread().contextClassLoader
        val packagePath = packageName.replace('.', '/')
        val classes = mutableListOf<Class<*>>()
        val urls = classLoader.getResources(packagePath)

        while (urls.hasMoreElements()) {
            val resource = urls.nextElement()
            classes.addAll(loadClasses(File(resource.file), packageName)!!)
        }

        return classes.filter { it.isAnnotationPresent(RestApi::class.java) }
    }


    @Throws(ClassNotFoundException::class)
    private fun loadClasses(directory: File, packageName: String): List<Class<*>> {
        val classSuffix = ".class"
        val classes = mutableListOf<Class<*>>()

        if (!directory.exists()) {
            return classes
        }

        directory.listFiles().forEach { file ->
            if (file.isDirectory) {
                classes.addAll(loadClasses(file, packageName + "." + file.name)!!)
            } else if (file.name.endsWith(classSuffix)) {
                classes.add(Class.forName(packageName + '.' + file.name.removeSuffix(classSuffix)))
            }
        }

        return classes
    }

}