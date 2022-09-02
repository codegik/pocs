package com.codegik.poc.converter.cache

import com.codegik.poc.converter.mapper.Mapper

class MapperCache(
    private val mapperCache: MutableMap<String, Any> = mutableMapOf(),
) {

    fun add(mapper: Mapper): Any {
        return mapperCache.getOrPut(mapper.name()) {
            mapper.generate()
        }
    }
}