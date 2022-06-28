package com.codegik.poc.kotlinrevertstring

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class App : CommandLineRunner {
	fun rev(str: String): String {
		val reversed: CharArray = CharArray(str.length)

		for (i in str.length - 1 downTo 0) {
			if (str[i] in 'a'..'z') {
				reversed[str.length - i - 2] = str[i]
			} else {
				reversed[i] = str[i]
			}
		}
		return reversed.concatToString()
	}

	override fun run(vararg args: String?) {
		println(rev("qwer%"))
		println(rev("*wer%"))
		println(rev("wer%tyui"))
	}
}


fun main(args: Array<String>) {
	runApplication<App>(*args)
}
