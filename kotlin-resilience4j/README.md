# Resilience4j POC

Testing resilience4j library features.

## Requirements
- Java 8
- Maven 3

## Circuit breaker

There are two apps running, the product app and shop app.
The shop app is requesting a service from product app.

### Testing

The test scenario is:
- starting two apps.
- stopping product app.
- starting product app again.

I've created a custom header called `isCached` that contain value `true` when the product app is down or `false` when the product app is up.

#### Run command
`$ ./test.sh`

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