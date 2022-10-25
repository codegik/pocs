package com.codegik.poc.converter

import com.codegik.poc.converter.annotation.Alias
import com.codegik.poc.converter.cache.ReflectionCache
import sun.misc.Unsafe
import java.lang.reflect.Field
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.jvm.javaField


class UnsafeConverter(val cache: ReflectionCache = ReflectionCache()) {

    object MyUnsafe {
        private val unsafe: Unsafe
        init {
            val f: Field = Unsafe::class.java.getDeclaredField("theUnsafe")
            f.isAccessible = true
            unsafe = f.get(null) as Unsafe
        }
        fun getInstance(): Unsafe {
            return unsafe
        }
    }


    fun from(from: Any): Convert {
        return Convert(from)
    }


    inner class Convert(private val from: Any) {
        fun <T> to(klass: Class<T>): T {
            val constructor = cache.constructor(klass)
            val targetInstance = constructor.newInstance() as T

            cache.memberProperties(targetInstance!!::class).map { targetField ->
                cache.memberProperties(from::class).firstOrNull { originField ->
                    targetField.name == originField.name ||
                    targetField.name == originField.findAnnotation<Alias>()?.name ||
                    originField.name == targetField.findAnnotation<Alias>()?.name
                }.let { sourceField ->
                    if (sourceField != null) {
                        val sourceOffset: Long = MyUnsafe.getInstance().objectFieldOffset(sourceField.javaField)
                        val targetOffset: Long = MyUnsafe.getInstance().objectFieldOffset(targetField.javaField)
                        val value: Any? = MyUnsafe.getInstance().getObject(from, sourceOffset)

                        MyUnsafe.getInstance().putObject(targetInstance, targetOffset, value)
                    }
                }
            }

            return targetInstance
        }
    }
}