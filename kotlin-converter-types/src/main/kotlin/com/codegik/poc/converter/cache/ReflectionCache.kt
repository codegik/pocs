package com.codegik.poc.converter.cache

import java.lang.reflect.Constructor
import java.lang.reflect.Field

class ReflectionCache(
    private val cacheConstructor: MutableMap<Class<*>, Constructor<*>> = mutableMapOf(),
    private val cacheField: MutableMap<Class<*>, Array<Field>> = mutableMapOf()
) {

    fun constructor(klass: Class<*>): Constructor<*> {
        return cacheConstructor.getOrPut(klass) {
            klass.constructors.first()
        }
    }

    fun declaredFields(klass: Class<*>): Array<Field> {
        return cacheField.getOrPut(klass) {
            klass.declaredFields
        }
    }

}
