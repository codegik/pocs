# Minions Party - Stress Test

This is a POC to run stress tests.

There are no external dependencies, everything is self-contained.


## Requirements
- Java 17
- Maven 3


## How it works
- Gru start listening on port `6666` with `100` threads by default.
- Gru is the central server to trigger commands to the minions and also to receive the metrics.
- Minions can connect to Gru and receive commands to execute.
- Minions will be sending the metrics to Gru.
- Gru and Minions are completely segregated, there are no dependencies between them. There is only love.


## Compiling and Running

### Starting Gru server

```shell
cd gru
./gru
```

### Starting Minion

```shell
cd minion
./minion
```

### Sending command to Gru

```shell
cd gru
./gru test '{"url": "https://google.com", "times": 200}'
```
This command will tell Gru to broadcast this action to all connected Minions.

Each Minion will receive this action and start execution.

In this case they will try to do a GET request 200 times in https://google.com.
