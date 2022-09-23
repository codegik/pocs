package com.codegik.poc.converter

import com.codegik.poc.converter.domain.Friend
import com.codegik.poc.converter.domain.Neighbor

fun main() {
    val jniConverter = JniConverter()
    val neighbor = Neighbor("Jeremy", "Jump", "email@gmail.com")
    val friend = jniConverter.from(neighbor).to(Friend::class.java)

    println(friend)
}