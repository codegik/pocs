package com.codegik.poc.groovy.birthday

import com.codegik.poc.groovy.domain.Person

import java.text.SimpleDateFormat

class BirthdayService {
    BirthdayDataProvider birthdayDataProvider

    BirthdayService(BirthdayDataProvider birthdayDataProvider) {
        this.birthdayDataProvider = birthdayDataProvider
    }

    List<Person> findByDate(String date) {
        def (_, monthParam, dayParam) = date.tokenize("-")
        birthdayDataProvider.loadPersons().findAll {
            def (year, month, day) = it.birthday.tokenize("-")
            monthParam == month && dayParam == day
        }
    }

    List<Person> findToday() {
        birthdayDataProvider.loadPersons().findAll {
            it.birthday.contains(new SimpleDateFormat("MM-dd").format(new Date()))
        }
    }

}
