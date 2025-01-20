package com.codegik

import org.springframework.boot.SpringApplication.run
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories

@SpringBootApplication
@EnableJdbcRepositories
class Application

object Application {

  def main(args: Array[String]): Unit = {
    run(classOf[Application], args *)
  }

}