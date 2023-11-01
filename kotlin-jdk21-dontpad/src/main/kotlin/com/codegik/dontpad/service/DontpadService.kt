package com.codegik.dontpad.service

import org.springframework.stereotype.Service
import java.util.concurrent.ConcurrentHashMap

@Service
class DontpadService {

    private val dontpads = ConcurrentHashMap<String, String>()

    fun create(dontpadName: String): Boolean {
        dontpads.putIfAbsent(dontpadName, "")

        return true
    }

    fun update(dontpadName: String, value: String): Boolean {
        dontpads[dontpadName] = value

        return true
    }

    fun value(dontpadName: String): String? {
        return dontpads[dontpadName]
    }

}