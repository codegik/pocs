package com.codegik.poc.github

import com.codegik.poc.github.service.GithubService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import kotlin.system.exitProcess

@SpringBootApplication
class App : CommandLineRunner {

    @Autowired
    private lateinit var githubService: GithubService

    override fun run(vararg args: String?) {
        githubService.findLastWeekPRs()
        exitProcess(0)
    }
}

fun main(args: Array<String>) {
    runApplication<App>(*args).close();
}
