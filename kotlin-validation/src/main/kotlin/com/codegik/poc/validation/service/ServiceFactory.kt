package com.codegik.poc.validation.service

import com.codegik.poc.validation.proxy.PersonServiceProxy
import kotlin.reflect.KClass

class ServiceFactory {
    companion object {
        fun <T : Any> instance(klass: KClass<out T>): T {
            return when(klass) {
                PersonService::class -> PersonServiceProxy() as T
                else -> throw RuntimeException("no proxy found for $klass")
            }
        }
    }
}