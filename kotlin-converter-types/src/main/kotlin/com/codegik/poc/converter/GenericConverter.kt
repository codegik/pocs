package com.codegik.poc.converter

import java.lang.reflect.Field
import kotlin.reflect.full.declaredMembers
import kotlin.reflect.full.memberProperties

class GenericConverter(val cache: Map<Class<*>, Array<Field>> = mutableMapOf()) {

    fun from(from: Any): Generic {
//        if (!cache.containsKey(from.javaClass)) {
//            cache[from.javaClass] = declaredFields
//        }

        val originFields = from.javaClass.declaredFields

        originFields.onEach { originField -> }

        return Generic(from)
    }


    class Generic(private val from: Any) {
        fun <T> to(klass: Class<T>): T {
            val constructor = klass.constructors.first()
            val args = mutableListOf<Any?>()

            args.addAll(
                klass.declaredFields.map { field ->
                    from::class.memberProperties
                        .firstOrNull { field.name == it.name }
                        ?.getter
                        ?.call(from)
                }
            )

            return constructor.newInstance(*args.toTypedArray()) as T
        }
    }
}