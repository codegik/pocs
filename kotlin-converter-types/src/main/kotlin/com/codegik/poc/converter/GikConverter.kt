package com.codegik.poc.converter

import com.codegik.poc.converter.cache.MapperCache
import com.codegik.poc.converter.mapper.Mapper
import kotlin.reflect.KClass

class GikConverter(val cache: MapperCache = MapperCache()) {

    fun from(from: Any): GikConvert {
        return GikConvert(from)
    }


    inner class GikConvert(private val from: Any) {
        fun <T : Any> to(klass: KClass<T>): T {
            val runtimeConverter = cache.add(Mapper(from::class, klass))
            return runtimeConverter.javaClass.declaredMethods.first().invoke(runtimeConverter, from) as T
        }
    }
}