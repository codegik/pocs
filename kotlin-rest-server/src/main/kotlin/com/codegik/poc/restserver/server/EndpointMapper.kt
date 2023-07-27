package com.codegik.poc.restserver.server

import com.codegik.poc.restserver.annotation.Get
import com.codegik.poc.restserver.annotation.Post
import com.codegik.poc.restserver.annotation.RestApi
import com.codegik.poc.restserver.handler.HttpRequestHandler
import java.io.File


object EndpointMapper {
    val mappedEndpoints = registerEndpoints().toMutableMap()

    private fun registerEndpoints(): Map<String, HttpRequestHandler> {
        val mappedEndpoints = mutableMapOf<String, HttpRequestHandler>()
        loadRestApiClasses().forEach { restApiClass ->
            val instance = restApiClass.constructors[0].newInstance()

            restApiClass.declaredMethods.forEach { method ->
                method.getAnnotation(Get::class.java).let {
                    val key = "${Get::class.simpleName!!.uppercase()} ${it.path}"
                    mappedEndpoints[key] = HttpRequestHandler(instance, method)
                    println("Mapping endpoint $key -> ${restApiClass.name}.${method.name}")
                }
                method.getAnnotation(Post::class.java).let {
                    val key = "${Post::class.simpleName!!.uppercase()} ${it.path}"
                    mappedEndpoints[key] = HttpRequestHandler(instance, method)
                    println("Mapping endpoint $key -> ${restApiClass.name}.${method.name}")
                }
            }
        }

        return mappedEndpoints
    }


    private fun loadRestApiClasses(): List<Class<*>> {
        val packageName = "com.codegik.poc.restserver"
        val classLoader = Thread.currentThread().contextClassLoader
        val packagePath = packageName.replace('.', '/')
        val classes = ArrayList<Class<*>>()
        val urls = classLoader.getResources(packagePath)

        while (urls.hasMoreElements()) {
            val resource = urls.nextElement()
            classes.addAll(findClasses(File(resource.file), packageName)!!)
        }

        return classes.filter { it.isAnnotationPresent(RestApi::class.java) }
    }


    @Throws(ClassNotFoundException::class)
    private fun findClasses(directory: File, packageName: String): List<Class<*>> {
        val classSuffix = ".class"
        val classes: MutableList<Class<*>> = ArrayList()

        if (!directory.exists()) {
            return classes
        }

        directory.listFiles().forEach { file ->
            if (file.isDirectory) {
                classes.addAll(findClasses(file, packageName + "." + file.name)!!)
            } else if (file.name.endsWith(classSuffix)) {
                classes.add(Class.forName(packageName + '.' + file.name.removeSuffix(classSuffix)))
            }
        }

        return classes
    }
}