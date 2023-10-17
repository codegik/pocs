# Kotlin Rest Server POC

This is a POC to create rest server from scratch.

There are no external dependencies, everything is self-contained.


## Requirements
- Java 17
- Maven 3


## How it works
- The server start listening on port `6666` with `100` threads by default.
- There is scan package at startup looking for endpoint definition.
- Mapped endpoints are classified by number of path parameters, this approach increase the performance when matching incoming requests to correspondent class method.

## Http Method

For now its supporting GET, POST and DELETE only.

## Samples

There is a embed dummy API listening on path `/hello`.

These sample are using `java.net.http` as http client. Don't need external library to call the API.

### Starting server

```kotlin
val server = HttpServer(9999)
server.start()
```


### GET /hello

```kotlin
val rootUrl = "http://localhost:9999"
val request = HttpRequest.newBuilder()
    .uri(URI("$rootUrl/hello"))
    .GET()
    .build()
val response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString())
```

### GET /hello/{name}

```kotlin
val rootUrl = "http://localhost:9999"
val request = HttpRequest.newBuilder()
    .uri(URI("$rootUrl/hello/Inácio"))
    .GET()
    .build()
val response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString())
```

### DELETE /hello

```kotlin
val rootUrl = "http://localhost:9999"
val request = HttpRequest.newBuilder()
    .uri(URI("$rootUrl/hello"))
    .DELETE()
    .build()
val response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString())
```

### POST /hello

```kotlin
val request = HttpRequest.newBuilder()
    .uri(URI("$rootUrl/hello"))
    .POST(BodyPublishers.ofString("body content"))
    .build()
val response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString())
```

## Compiling and Testing

```
./mvnw clean install
```

## Running
```
./run
```

## TODO
- Add urlencode/decode support for request parameters.
- Add support to parse json in body request and response.

