
package com.codegik.poc.groovy

import com.codegik.poc.groovy.birthday.BirthdayDataProvider
import com.codegik.poc.groovy.birthday.BirthdayService

class App {

    static void main(String[] args) {
        def birthday = new BirthdayService(new BirthdayDataProvider())

        println "looking for 2000-12-10: ${birthday.findByDate("2000-12-10")}"
        println "looking for 1990-05-01: ${birthday.findByDate("1990-05-01")}"
        println "looking for 1970-01-01: ${birthday.findByDate("1970-01-01")}"
        println "looking for today: ${birthday.findToday()}"
    }
}
