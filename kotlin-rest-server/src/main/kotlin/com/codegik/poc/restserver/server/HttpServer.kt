package com.codegik.poc.restserver.server

import com.codegik.poc.restserver.annotation.Get
import com.codegik.poc.restserver.annotation.RestApi
import com.codegik.poc.restserver.handler.GetRequestHandler
import java.io.File
import java.net.ServerSocket
import java.util.ArrayList
import kotlin.concurrent.thread


class HttpServer(port: Int = 6666) {
    private var isAcceptingRequests = true
    private val serverSocket: ServerSocket = ServerSocket(port)

    fun start() {
        println("Server start listening")
        while (isAcceptingRequests) {
            val clientSocket = serverSocket.accept()
            // TODO: use thread pool instead create new thread every call
            thread {
                RequestDispatcher(clientSocket, this).process()
            }
        }
        println("Server stop listening")
    }


    fun scanEndpoints() {
        // TODO: register classes to listening endpoints
        val mappedEndpoints = mutableListOf<String>()
        loadRestApiClasses().forEach { restApiClass ->
            val instance = restApiClass.constructors[0].newInstance()
            restApiClass.declaredMethods.forEach { method ->
                method.getAnnotation(Get::class.java).let {
                    mappedEndpoints += "${it.path}"
                    println("Mapping endpoint ${it.path} -> ${restApiClass.name}.${method.name}")
                }
                // todo: add more request type here
            }
        }
    }


    fun getEndpointHandler(endpoint: String): Handler {
        
    }


    fun stop() {
        serverSocket.close()
        isAcceptingRequests = false
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