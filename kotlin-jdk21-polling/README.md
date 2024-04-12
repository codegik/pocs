# Short Polling, Long Polling and Websockets

This POC is to demonstrate the difference between short polling, long polling and websockets.

There is no UI here, everything is running in the terminal, thanks to [Websocat](https://github.com/vi/websocat).

## Requirements
- Java 21
- Maven 3
- Websocat

## Start Server

Open `terminal 1` and run this command.
```shell
./mvnw clean install

java -jar target/polling*.jar
```

## Short Polling Test
Open `terminal 2` and run this command.
```shell
watch -n 2 curl --silent http://localhost:8080/message
```

You will see the message `Client requesting message` being printed every 2 seconds on the server.

Open `terminal 3` and run this command.
```shell
curl http://localhost:8080/message -d 'my message'
curl http://localhost:8080/message -d 'other message'
```

You will see these messages above being printed every 2 seconds on the `terminal 2`.

To delete the message, run this command on `terminal 3`.
```shell
curl --request "DELETE" http://localhost:8080/message
```

The message is not appearing anymore on `terminal 2`.

## Long Polling Test
Go to `terminal 2`, stop current execution and run this command.
```shell
curl http://localhost:8080/wait-for-message
```

You will see the message `Client waiting for message` being printed on the server.
This happens due a thread running in backend waiting for some message. The connection with the client still open.

Go to `terminal 3` and run this command to send a message.
```shell
curl http://localhost:8080/message -d 'I have good news'
```

The message `I have good news` will appear on `terminal 2` and the connection will be closed.

## Websocket Test
Go to `terminal 2` and execute this command.
```shell
websocat ws://localhost:8080/real-time-message
```
Go to `terminal 3` and execute same command.
```shell
websocat ws://localhost:8080/real-time-message
```

You can see the message `New client <uuid> connected` being printed on the server.

Now you're able to type any message in `terminal 2 or 3` and see the message in the other terminal.

Have some fun sending messages.

Open `terminal 4` and run this command to broadcast a message to all clients.
```shell
curl http://localhost:8080/broadcast-message -d 'this is a message from server'
```

The message will appear on `terminal 2` and `terminal 3`.