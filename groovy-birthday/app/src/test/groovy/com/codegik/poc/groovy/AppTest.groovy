package com.codegik.poc.groovy

import com.codegik.poc.groovy.birthday.BirthdayDataProvider
import com.codegik.poc.groovy.birthday.BirthdayService
import spock.lang.Specification

class AppTest extends Specification {
    def "birthdate greeting"() {
        setup:
        def birthday = new BirthdayService(new BirthdayDataProvider())

        when:
        def result = birthday.findByDate("2000-12-10")

        then:
        result.size() == 2
    }
}
