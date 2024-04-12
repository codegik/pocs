# Dontpad = Kotlin + Thymeleaf + Websocket + Htmx

This is a POC inspired in https://dontpad.com/

## Requirements
- Java 21
- Maven 3

## Testing

```shell
mvn clean install
```

## Running

Open terminal 1 and run this command.
```shell
./mvnw spring-boot:run
```

Open terminal 2 and run this command.
```shell
watch -n 2 curl --silent http://localhost:8080/message
```

Open terminal 3 and run this command.
```shell
curl http://localhost:8080/message -d 'my message'
curl http://localhost:8080/message -d 'other message'
curl --request "DELETE" http://localhost:8080/message
```

Go to terminal 2, stop current execution and run this command.
```shell
curl http://localhost:8080/wait-for-message
```

Go to terminal 2 and run this command.
```shell
curl http://localhost:8080/message -d 'I have good news'
```
