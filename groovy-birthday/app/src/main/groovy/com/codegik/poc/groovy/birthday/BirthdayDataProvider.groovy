package com.codegik.poc.groovy.birthday

import com.codegik.poc.groovy.domain.Person

class BirthdayDataProvider {

    List<Person> loadPersons() {
        def persons = new ArrayList<Person>()
        def file = new File(getClass().getResource('/person.csv').toURI())

        file.eachLine { line ->
            def (name, birthDay, city) = line.tokenize(",")
            persons << new Person(name.trim(), birthDay.trim(), city.trim())
        }.collect()
    }
}
