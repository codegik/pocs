# Resilience4j POC

Testing resilience4j library features.

## Requirements
- Java 8
- Maven 3

## Circuit breaker

There are two apps running, the product app and shop app.
The shop app is requesting a service from product app.

### Testing Circuit Breaker

The test scenario is:
- starting two apps.
- stopping product app.
- starting product app again.

I've created a custom header called `isCached` that contain value `true` when the product app is down or `false` when the product app is up.

#### Run command
`$ ./test-circuitbreaker.sh`

#### Output sample
```                                                                                                                                              45s
skipping build for product
skipping build for shop
product pid = 44946
shop pid = 44948


### trying number 1 ###
curl: (7) Failed to connect to localhost port 9090: Connection refused


### trying number 2 ###
curl: (7) Failed to connect to localhost port 9090: Connection refused


### trying number 3 ###
curl: (7) Failed to connect to localhost port 9090: Connection refused


### trying number 4 ###
HTTP/1.1 200
isCached: false
Content-Type: application/json
Transfer-Encoding: chunked
Date: Tue, 12 Jul 2022 12:38:46 GMT

{"id":"1","products":[{"id":"1","name":"Table chair","width":30,"height":50},{"id":"2","name":"Outside chair","width":100,"height":80},{"id":"3","name":"Weird chair","width":100,"height":20}]}

### trying number 5 ###
HTTP/1.1 200
isCached: false
Content-Type: application/json
Transfer-Encoding: chunked
Date: Tue, 12 Jul 2022 12:38:49 GMT

{"id":"1","products":[{"id":"1","name":"Table chair","width":30,"height":50},{"id":"2","name":"Outside chair","width":100,"height":80},{"id":"3","name":"Weird chair","width":100,"height":20}]}

### stopping product app ###


### trying number 6 ###
HTTP/1.1 200
isCached: true
Content-Type: application/json
Transfer-Encoding: chunked
Date: Tue, 12 Jul 2022 12:38:54 GMT

{"id":"1","products":[{"id":"1","name":"Table chair","width":30,"height":50},{"id":"2","name":"Outside chair","width":100,"height":80},{"id":"3","name":"Weird chair","width":100,"height":20}]}

### trying number 7 ###
HTTP/1.1 200
isCached: true
Content-Type: application/json
Transfer-Encoding: chunked
Date: Tue, 12 Jul 2022 12:38:58 GMT

{"id":"1","products":[{"id":"1","name":"Table chair","width":30,"height":50},{"id":"2","name":"Outside chair","width":100,"height":80},{"id":"3","name":"Weird chair","width":100,"height":20}]}

### trying number 8 ###
HTTP/1.1 200
isCached: true
Content-Type: application/json
Transfer-Encoding: chunked
Date: Tue, 12 Jul 2022 12:39:02 GMT

{"id":"1","products":[{"id":"1","name":"Table chair","width":30,"height":50},{"id":"2","name":"Outside chair","width":100,"height":80},{"id":"3","name":"Weird chair","width":100,"height":20}]}

### trying number 9 ###
HTTP/1.1 200
isCached: true
Content-Type: application/json
Transfer-Encoding: chunked
Date: Tue, 12 Jul 2022 12:39:06 GMT

{"id":"1","products":[{"id":"1","name":"Table chair","width":30,"height":50},{"id":"2","name":"Outside chair","width":100,"height":80},{"id":"3","name":"Weird chair","width":100,"height":20}]}

### trying number 10 ###
HTTP/1.1 200
isCached: true
Content-Type: application/json
Transfer-Encoding: chunked
Date: Tue, 12 Jul 2022 12:39:10 GMT

{"id":"1","products":[{"id":"1","name":"Table chair","width":30,"height":50},{"id":"2","name":"Outside chair","width":100,"height":80},{"id":"3","name":"Weird chair","width":100,"height":20}]}

### starting product app ###
product pid = 45131


### trying number 11 ###
HTTP/1.1 200
isCached: true
Content-Type: application/json
Transfer-Encoding: chunked
Date: Tue, 12 Jul 2022 12:39:14 GMT

{"id":"1","products":[{"id":"1","name":"Table chair","width":30,"height":50},{"id":"2","name":"Outside chair","width":100,"height":80},{"id":"3","name":"Weird chair","width":100,"height":20}]}

### trying number 12 ###
HTTP/1.1 200
isCached: true
Content-Type: application/json
Transfer-Encoding: chunked
Date: Tue, 12 Jul 2022 12:39:18 GMT

{"id":"1","products":[{"id":"1","name":"Table chair","width":30,"height":50},{"id":"2","name":"Outside chair","width":100,"height":80},{"id":"3","name":"Weird chair","width":100,"height":20}]}

### trying number 13 ###
HTTP/1.1 200
isCached: false
Content-Type: application/json
Transfer-Encoding: chunked
Date: Tue, 12 Jul 2022 12:39:21 GMT

{"id":"1","products":[{"id":"1","name":"Table chair","width":30,"height":50},{"id":"2","name":"Outside chair","width":100,"height":80},{"id":"3","name":"Weird chair","width":100,"height":20}]}

### trying number 14 ###
HTTP/1.1 200
isCached: false
Content-Type: application/json
Transfer-Encoding: chunked
Date: Tue, 12 Jul 2022 12:39:25 GMT

{"id":"1","products":[{"id":"1","name":"Table chair","width":30,"height":50},{"id":"2","name":"Outside chair","width":100,"height":80},{"id":"3","name":"Weird chair","width":100,"height":20}]}

### trying number 15 ###
HTTP/1.1 200
isCached: false
Content-Type: application/json
Transfer-Encoding: chunked
Date: Tue, 12 Jul 2022 12:39:28 GMT

{"id":"1","products":[{"id":"1","name":"Table chair","width":30,"height":50},{"id":"2","name":"Outside chair","width":100,"height":80},{"id":"3","name":"Weird chair","width":100,"height":20}]}

### test complete: stopping all apps ###
```


### Testing Retry

The test scenario is:
- starting product app when product app is down.

#### Run command
`$ ./test-retry.sh`

#### Output sample
```log
skipping build for shop
shop pid = 48627

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.7.1)

2022-07-18 19:43:25.393  INFO 48627 --- [           main] c.c.poc.javaresilience4j.ShopAppKt       : Starting ShopAppKt v0.0.1-SNAPSHOT using Java 1.8.0_322 on C02G808V0KPF with PID 48627 (/Users/iklassman/sources/pocs/kotlin-resilience4j/shop/target/kotlin-resilience4j-shop-0.0.1-SNAPSHOT.jar started by iklassman in /Users/iklassman/sources/pocs/kotlin-resilience4j)
2022-07-18 19:43:25.400  INFO 48627 --- [           main] c.c.poc.javaresilience4j.ShopAppKt       : No active profile set, falling back to 1 default profile: "default"


### trying number 1 ###
curl: (7) Failed to connect to localhost port 9090: Connection refused
2022-07-18 19:43:28.585  INFO 48627 --- [           main] o.s.cloud.context.scope.GenericScope     : BeanFactory id=aad96f74-0f73-3d15-8ef8-63d0bf6c1750
2022-07-18 19:43:29.295  INFO 48627 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 9090 (http)
2022-07-18 19:43:29.314  INFO 48627 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2022-07-18 19:43:29.314  INFO 48627 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.64]
2022-07-18 19:43:29.468  INFO 48627 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2022-07-18 19:43:29.469  INFO 48627 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 3928 ms


### trying number 2 ###
curl: (7) Failed to connect to localhost port 9090: Connection refused
2022-07-18 19:43:31.370  INFO 48627 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 9090 (http) with context path ''
2022-07-18 19:43:31.427  INFO 48627 --- [           main] c.c.poc.javaresilience4j.ShopAppKt       : Started ShopAppKt in 7.676 seconds (JVM running for 8.691)


### trying number 3 ###
2022-07-18 19:43:33.731  INFO 48627 --- [nio-9090-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2022-07-18 19:43:33.731  INFO 48627 --- [nio-9090-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2022-07-18 19:43:33.734  INFO 48627 --- [nio-9090-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 3 ms
2022-07-18 19:43:34.935  INFO 48627 --- [nio-9090-exec-1] c.c.p.j.controller.ShopController        : Requesting external service attempt 1
2022-07-18 19:43:36.461  INFO 48627 --- [nio-9090-exec-1] c.c.p.j.controller.ShopController        : Requesting external service attempt 2
2022-07-18 19:43:38.001  INFO 48627 --- [nio-9090-exec-1] c.c.p.j.controller.ShopController        : Requesting external service didn't worked, tried 3 attempts, returning default cart
HTTP/1.1 200
Content-Type: application/json
Transfer-Encoding: chunked
Date: Mon, 18 Jul 2022 22:43:38 GMT

{"id":"1","products":[]}

### trying number 4 ###
2022-07-18 19:43:42.249  INFO 48627 --- [nio-9090-exec-2] c.c.p.j.controller.ShopController        : Requesting external service attempt 1
2022-07-18 19:43:43.760  INFO 48627 --- [nio-9090-exec-2] c.c.p.j.controller.ShopController        : Requesting external service attempt 2
2022-07-18 19:43:45.268  INFO 48627 --- [nio-9090-exec-2] c.c.p.j.controller.ShopController        : Requesting external service didn't worked, tried 3 attempts, returning default cart
HTTP/1.1 200
Content-Type: application/json
Transfer-Encoding: chunked
Date: Mon, 18 Jul 2022 22:43:45 GMT

{"id":"1","products":[]}

### trying number 5 ###
2022-07-18 19:43:49.324  INFO 48627 --- [nio-9090-exec-3] c.c.p.j.controller.ShopController        : Requesting external service attempt 1
2022-07-18 19:43:50.838  INFO 48627 --- [nio-9090-exec-3] c.c.p.j.controller.ShopController        : Requesting external service attempt 2
2022-07-18 19:43:52.349  INFO 48627 --- [nio-9090-exec-3] c.c.p.j.controller.ShopController        : Requesting external service didn't worked, tried 3 attempts, returning default cart
HTTP/1.1 200
Content-Type: application/json
Transfer-Encoding: chunked
Date: Mon, 18 Jul 2022 22:43:52 GMT

{"id":"1","products":[]}

### test complete: stopping app ###
```