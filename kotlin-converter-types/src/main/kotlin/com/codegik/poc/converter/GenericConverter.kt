package com.codegik.poc.converter

import com.codegik.poc.converter.annotation.Alias
import com.codegik.poc.converter.cache.ReflectionCache
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.memberProperties

class GenericConverter(private val cache: ReflectionCache = ReflectionCache()) {

    fun from(from: Any): Convert {
        return Convert(from)
    }

    inner class Convert(private val from: Any) {
        fun <T> to(klass: Class<T>): T {
            val constructor = cache.constructor(klass)
            val args = mutableListOf<Any?>()

            args.addAll(
                cache.declaredFields(klass).map { klassField ->
                    from::class.memberProperties.firstOrNull { fromField ->
                        klassField.name == fromField.name ||
                        klassField.name == fromField.findAnnotation<Alias>()?.name
                    }
                        ?.getter
                        ?.call(from)
                }
            )

            return constructor.newInstance(*args.toTypedArray()) as T
        }
    }
}