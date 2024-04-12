# Short Polling, Long Polling and Websockets

## Requirements
- Java 21
- Maven 3
- Websocat

## Running

Open terminal 1 and run this command.
```shell
./mvnw spring-boot:run
```

### Short Polling
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

### Long Polling
Go to terminal 2, stop current execution and run this command.
```shell
curl http://localhost:8080/wait-for-message
```

Go to terminal 2 and run this command.
```shell
curl http://localhost:8080/message -d 'I have good news'
```

### Websocket
Go to terminal 2 and execute this command.
```shell
websocat ws://localhost:8080/real-time-message
```
Go to terminal 3 and execute this command.
```shell
websocat ws://localhost:8080/real-time-message
```
Now you're able to type any message in terminal 2 or 3 and see the message in the other terminal.

Have some fun sending messages.

Open terminal 4 and run this command.
```shell
curl http://localhost:8080/broadcast-message -d 'this is a message from server'
```