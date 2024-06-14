# Slow hibernate query detector

This is a POC to identify hibernate slow queries.

## Requirements 
- Java 21
- Maven 3

## Context
This POC can help to identify slow queries running by hibernate library.

All necessary configuration is on `application.properties` file. 

This is the property to enable hibernate statics using spring-boot.
```shell
spring.jpa.properties.hibernate.generate_statistics=true
```

If you're not using spring-boot, this is the property to enable it.
```shell
hibernate.generate_statistics=true
```

Basically, that is all we need to collect hibernate statistics. From now on, we can use the information to do anything, i.e. expose metrics, send to monitoring system, publish to a queue, etc.

Here is an example of a class to collect statistics: [HibernateStatisticsService](src/main/kotlin/com/codegik/hibernate/service/HibernateStatisticsService.kt)

## Running
```shell
./mvnw clean install
```
