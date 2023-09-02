# Kotlin Rest Server (WIP)

This is a POC to create rest server from scratch.

There are no external dependencies, everything is self-contained.


## Requirements
- Java 17
- Maven 3


## How it works
- The server start listening on port `6666` with `100` threads by default.
- There is scan package at startup looking for endpoint definition.
- Mapped endpoints are classified by number of path parameters.

## Compiling and Testing

```
./mvnw clean install
```

## Running
```
./run
```

