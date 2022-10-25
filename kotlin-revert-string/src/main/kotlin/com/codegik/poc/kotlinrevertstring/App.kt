package com.codegik.poc.kotlinrevertstring

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class App : CommandLineRunner {

	fun leftRotate(str: String, d: Int): String {
		return str.substring(d) + str.substring(0, d)
	}

	/**
	 * reversed = "q", i = 4
	 * reversed = "%q", i = 3
	 * reversed = "r%q", i = 2
	 * reversed = "er%q", i = 1
	 * reversed = "rew%q", i = 0
 	 */


	fun rev(str: String): String {
		var reversed = ""
		for (i in 0..str.length - 1) {
			if (str[i] in 'a'..'z') {
				reversed = str[i] + reversed
			} else if (i == 0) {
				reversed = str[i] + reversed
			} else {
				reversed = reversed.substring(0, i-1) + str[i] + reversed.substring(i-1)
			}
		}

		return reversed
	}

	override fun run(vararg args: String?) {
		println(rev("qwe%r"))
		println(rev("*wer%"))
		println(rev("wer%tyui"))
	}
}


fun main(args: Array<String>) {
	runApplication<App>(*args)
}
