package com.codegik.poc.converter.cache

import com.codegik.poc.converter.mapper.Mapper

class MapperCache(
    private val mapperCache: MutableMap<String, Mapper> = mutableMapOf(),
) {

    fun map(mapper: Mapper): Mapper {
        return mapperCache.getOrPut(mapper.name()) {
            mapper
        }
    }
}