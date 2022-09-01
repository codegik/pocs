package com.codegik.poc.converter

import com.codegik.poc.converter.cache.MapperCache
import com.codegik.poc.converter.mapper.Mapper

class GikConverter(private val cache: MapperCache = MapperCache()) {

    fun from(from: Any): GikConvert {
        return GikConvert(from)
    }


    inner class GikConvert(private val from: Any) {

        fun <T> to(klass: Class<T>): String {
            val mapper = cache.map(Mapper(from::class.java, klass))
            val result = mapper.generate()
            return "d"
        }
    }
}