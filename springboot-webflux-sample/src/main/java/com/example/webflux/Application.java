package com.example.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.*")
public class Application {
    public static void main(String[] args) {
//        System.setProperty("reactor.schedulers.defaultBoundedElasticOnVirtualThreads", "true");
        System.setProperty("reactor.schedulers.defaultBoundedElasticOnVirtualThreads", "true");
        System.setProperty("reactor.schedulers.defaultBoundedElasticSize", "200");
        System.setProperty("reactor.schedulers.defaultPoolSize", "200");
        SpringApplication.run(Application.class, args);
    }
}
