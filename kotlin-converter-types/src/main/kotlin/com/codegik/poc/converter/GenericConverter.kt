package com.codegik.poc.converter

import com.codegik.poc.converter.annotation.Alias
import com.codegik.poc.converter.cache.ReflectionCache
import kotlin.reflect.KMutableProperty1
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.memberProperties

class GenericConverter(val cache: ReflectionCache = ReflectionCache()) {

    fun from(from: Any): Convert {
        return Convert(from)
    }


    inner class Convert(private val from: Any) {
        fun <T> to(klass: Class<T>): T {
            val constructor = cache.constructor(klass)
            val instance = constructor.newInstance() as T

            cache.declaredFields(instance!!::class).map { targetField ->
                from::class.memberProperties.firstOrNull { originField ->
                    targetField.name == originField.name ||
                    targetField.name == originField.findAnnotation<Alias>()?.name ||
                    originField.name == targetField.findAnnotation<Alias>()?.name
                }.let {
                    if (it != null) {
                        (targetField as KMutableProperty1).setter.call(instance, it?.getter?.call(from))
                    }
                }
            }

            return instance
        }
    }
}