package com.codegik.poc.groovy.domain

class Person {
    String name
    String birthday
    String city

    Person(String name, String birthday, String city) {
        this.name = name
        this.birthday = birthday
        this.city = city
    }


    @Override
    String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
