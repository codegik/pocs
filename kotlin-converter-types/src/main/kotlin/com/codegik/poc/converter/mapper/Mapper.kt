package com.codegik.poc.converter.mapper

import com.codegik.poc.converter.annotation.Alias
import javassist.ClassPool
import javassist.CtClass
import javassist.CtField
import javassist.CtNewMethod
import javassist.Modifier


class Mapper(val originClass: Class<*>, val targetClass: Class<*>) {

    fun name(): String {
        return "${originClass.simpleName}_to_${targetClass.simpleName}"
    }

    fun generate(): Class<*> {
        val className: String = "com.codegik.poc.converter.mapper.${name()}"

        return try {
            Class.forName(className)
        } catch (e: ClassNotFoundException) {
            buildClass(className)
        }
    }


    fun buildClass(className: String): Class<*> {
        val pool: ClassPool = ClassPool.getDefault()
        val klass: CtClass = pool.makeClass(className)
        val originType: CtClass = pool.get(originClass.name)
        val targetType: CtClass = pool.get(targetClass.name)
        val fromField = CtField(originType, "from", klass)
        val toField = CtField(targetType, "to", klass)

        fromField.modifiers = Modifier.PUBLIC
        toField.modifiers = Modifier.PUBLIC

        val bodyConvert = buildBodyConvert()

        val methodConvert = CtNewMethod.make(Modifier.PUBLIC, originType, "convert",
            listOf(originType).toTypedArray(), null, bodyConvert, klass)

        klass.toClass(targetClass.javaClass.classLoader, targetClass.javaClass.protectionDomain)

        return Class.forName(className)
    }


    fun buildBodyConvert(): String {
        var body = listOf<String>()
        body += "${targetClass.name} result = new ${targetClass}();"

        originClass.declaredFields.map { originField ->
            targetClass.declaredFields.firstOrNull { targetField ->
                originField.name == targetField.name ||
                        (targetField.isAnnotationPresent(Alias::class.java) &&
                                originField.name == targetField.getAnnotation(Alias::class.java).name)
            }?.let {
                body += "result.${originField.name} = ${it.name}"
            }
        }

        body += "return result;"

        return body.joinToString("\n");
    }
}