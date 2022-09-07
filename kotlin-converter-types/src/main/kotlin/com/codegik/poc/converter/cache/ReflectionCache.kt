package com.codegik.poc.converter.cache

import java.lang.reflect.Constructor
import kotlin.reflect.KClass
import kotlin.reflect.KProperty1
import kotlin.reflect.full.memberProperties

class ReflectionCache(
    private val cacheConstructor: MutableMap<Class<*>, Constructor<*>> = mutableMapOf(),
    private val cacheField: MutableMap<KClass<out Any>, Collection<KProperty1<*, *>>> = mutableMapOf()
) {

    fun constructor(klass: Class<*>): Constructor<*> {
        return cacheConstructor.getOrPut(klass) {
            klass.constructors.first()
        }
    }

    fun declaredFields(klass: KClass<out Any>): Collection<KProperty1<*, *>> {
        return cacheField.getOrPut(klass) {
            klass.memberProperties
        }
    }

    fun size(): Pair<Int, Int> {
        return Pair(cacheConstructor.size, cacheField.size)
    }
}