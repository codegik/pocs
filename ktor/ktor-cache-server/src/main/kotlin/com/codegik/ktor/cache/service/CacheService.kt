package com.codegik.ktor.cache.service

class CacheService {
    private val cache = mutableMapOf<String, String>()

    fun get(key: String): String? {
        return cache[key]
    }

    fun save(key: String, value: String): Boolean {
        if (cache.containsKey(key)) {
            return false
        }

        cache[key] = value
        return true
    }

    fun upsert(key: String, value: String): Boolean {
        cache[key] = value
        return true
    }

    fun delete(key: String): Boolean {
        if (!cache.containsKey(key)) {
            return false
        }
        cache.remove(key)
        return true
    }
}