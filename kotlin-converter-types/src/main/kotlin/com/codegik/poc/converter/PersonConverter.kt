package com.codegik.poc.converter

import com.codegik.poc.converter.domain.Friend
import com.codegik.poc.converter.domain.Person

class PersonConverter: Converter<Person, Friend> {
    override fun from(from: Person): Friend {
        return Friend(name = from.name, age = from.age, email = from.address)
    }
}