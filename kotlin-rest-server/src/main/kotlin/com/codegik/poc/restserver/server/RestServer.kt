package com.codegik.poc.restserver.server

import com.codegik.poc.restserver.annotation.Get
import com.codegik.poc.restserver.annotation.RestApi
import com.codegik.poc.restserver.handler.GetRequestHandler
import com.sun.net.httpserver.HttpServer
import java.io.File
import java.net.InetSocketAddress
import java.net.ServerSocket
import java.net.Socket
import java.util.*
import java.util.concurrent.Executors


class RestServer {
    private val serverSocket: ServerSocket? = ServerSocket(6666)

    fun start(): List<String> {
        val threadPoolExecutor = Executors.newFixedThreadPool(10)
        val server = HttpServer.create(InetSocketAddress("localhost", 6666), 0)
        val mappedEndpoints = mutableListOf<String>()

        loadRestApiClasses().forEach { restApiClass ->
            val instance = restApiClass.constructors[0].newInstance()
            restApiClass.declaredMethods.forEach { method ->
                method.getAnnotation(Get::class.java).let {
                    server.createContext(it.path, GetRequestHandler(instance, method))
                    mappedEndpoints += "${it.path}"
                    println("Mapping endpoint ${it.path} -> ${restApiClass.name}.${method.name}")
                }
                // todo: add more request type here
            }
        }

        server.executor = threadPoolExecutor
        server.start()
        return mappedEndpoints
    }

    fun loadRestApiClasses(): List<Class<*>> {
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