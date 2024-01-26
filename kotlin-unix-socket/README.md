# Unix Socket + Kotlin

This is a POC to have fun with  [Unix Socket](https://www.howtogeek.com/devops/what-are-unix-sockets-and-how-do-they-work/) + Kotlin Language.

The `client` and `server` applications are two independent processes and they are communicating each other using Unix Socket.

Basically, `server` is printing message received from `client`, simple as that.

There are no external dependencies (libraries), everything is self-contained.


## Requirements
- Java 17
- Maven 3


## Running server
Server should be started first and will be waiting for connection.
```
❯ ./server
[Server] initializing...
[Server] Started
```

## Running client
Open new terminal and start the client.
```
❯ ./client
[Client] initializing...
[Client] Started
[Client] Message sent
```

## Server receive message
Server receives the message and append to terminal.
```
[Server] initializing...
[Server] Started
[Client message] Hello people, I came by unix sockets
```


