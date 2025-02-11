package com.codegik.config

import com.google.gson.{Gson, GsonBuilder}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.{Bean, Configuration}

import java.net.http.HttpClient

@Configuration
class HttpClientConfig @Autowired() {

  @Bean
  def getWebClient: HttpClient = {
    HttpClient.newBuilder().build()
  }

  @Bean
  def gson: Gson = {
    GsonBuilder().create()
  }

}