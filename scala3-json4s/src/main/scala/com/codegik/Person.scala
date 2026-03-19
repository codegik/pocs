package com.codegik

case class Person(name: String, age: Int, email: String)

case class Address(street: String, city: String, zipCode: String)

case class PersonWithAddress(person: Person, address: Address)
