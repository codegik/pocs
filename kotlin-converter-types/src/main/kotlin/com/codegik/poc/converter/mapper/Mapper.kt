package com.codegik.poc.converter.mapper

import com.codegik.poc.converter.annotation.Alias
import javassist.ClassPool
import javassist.CtClass
import javassist.CtMethod
import javassist.CtNewConstructor
import javassist.CtNewMethod
import javassist.LoaderClassPath
import javassist.Modifier
import kotlin.reflect.KClass
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.memberProperties


class Mapper(private val originClass: KClass<*>, private val targetClass: KClass<*>) {

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

        pool.appendClassPath(LoaderClassPath(this::class.java.classLoader))
        pool.importPackage("com.codegik.poc.converter")

        val klass: CtClass = pool.makeClass(className)

        klass.addConstructor(CtNewConstructor.make("public ${name()} () {}", klass))
        klass.addMethod(buildConvertMethod(klass))
        klass.modifiers = Modifier.PUBLIC

        return Class.forName(className)
    }


    fun buildConvertMethod(klass: CtClass): CtMethod {
        var method = listOf<String>()
        method += "public ${targetClass.qualifiedName} convert(${originClass.qualifiedName} from) {"
        method += "${targetClass.qualifiedName} to = new ${targetClass.qualifiedName}();"

        originClass.memberProperties.forEach { originField ->
            targetClass.memberProperties.firstOrNull { targetField ->
                originField.name == targetField.name ||
                originField.name == targetField.findAnnotation<Alias>()?.name ||
                targetField.name == originField.findAnnotation<Alias>()?.name
            }?.let { field ->
                val setter = "set${field.name.replaceFirstChar { it.uppercase() }}"
                val getter = "get${originField.name.replaceFirstChar { it.uppercase() }}"
                method += "to.$setter(from.$getter());"
            }
        }

        method += "return to;"
        method += "}"

        return CtNewMethod.make(method.joinToString("\n"), klass)
    }

}