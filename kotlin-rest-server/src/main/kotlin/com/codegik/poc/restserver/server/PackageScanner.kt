package com.codegik.poc.restserver.server

import com.codegik.poc.restserver.annotation.RestApi
import java.io.File

class PackageScanner(
    private val packageName: String = "com.codegik.poc.restserver"
) {


    fun loadRestApiClasses(): List<Class<*>> {
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