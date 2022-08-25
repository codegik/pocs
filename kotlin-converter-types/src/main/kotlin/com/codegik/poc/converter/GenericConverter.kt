package com.codegik.poc.converter

import com.codegik.poc.converter.annotation.Alias
import java.lang.reflect.Field
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.memberProperties

class GenericConverter(val cache: Map<Class<*>, Array<Field>> = mutableMapOf()) {

    fun from(from: Any): Convert {
        return Convert(from)
    }


    class Convert(private val from: Any) {
        fun <T> to(klass: Class<T>): T {
            val constructor = klass.constructors.first()
            val args = mutableListOf<Any?>()

            args.addAll(
                klass.declaredFields.map { klassField ->
                    from::class.memberProperties.firstOrNull { fromField ->
                        klassField.name == fromField.name || klassField.name == fromField.findAnnotation<Alias>()?.name
                    }
                        ?.getter
                        ?.call(from)
                }
            )

            return constructor.newInstance(*args.toTypedArray()) as T
        }
    }
}