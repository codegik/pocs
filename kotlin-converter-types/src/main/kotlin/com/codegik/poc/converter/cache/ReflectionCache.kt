package com.codegik.poc.converter.cache

import java.lang.reflect.Constructor
import java.lang.reflect.Field
import java.util.concurrent.ConcurrentHashMap
import kotlin.reflect.KClass
import kotlin.reflect.KProperty1
import kotlin.reflect.full.memberProperties

class ReflectionCache(
    private val cacheConstructor: MutableMap<Class<*>, Constructor<*>> = ConcurrentHashMap(),
    private val cacheDeclaredField: MutableMap<KClass<out Any>, Collection<KProperty1<*, *>>> = ConcurrentHashMap(),
    private val cacheField: MutableMap<String, Field> = ConcurrentHashMap()
) {

    fun constructor(klass: Class<*>): Constructor<*> {
        return cacheConstructor.getOrPut(klass) {
            klass.constructors.first()
        }
    }

    fun memberProperties(klass: KClass<out Any>): Collection<KProperty1<*, *>> {
        return cacheDeclaredField.getOrPut(klass) {
            klass.memberProperties
        }
    }

    fun size(): Pair<Int, Int> {
        return Pair(cacheConstructor.size, cacheDeclaredField.size)
    }
}