# Unix Pipe + Kotlin

This is a POC to have fun with  [Unix Pipes](https://www.geeksforgeeks.org/piping-in-unix-or-linux/) + Kotlin Language.

The `producer` and `consumer` applications are two independent processes and they are communicating each other using Unix Pipes.

Basically, `consumer` is printing message received from `producer`, simple as that.

There are no external dependencies (libraries), everything is self-contained.


## Requirements
- Java 17
- Maven 3


## Running producer alone
Producer is going to print timestamp every one second. (Press ctrl+c to stop)
```shell
❯ ./producer
340474290609833
340475298871333
340476305636791
340477308660166
<ctrl+c>
```

## Running producer | consumer
Running both process with `|` will make producer send each value to consumer, and consumer will print the value.
```shell
❯ ./producer | ./consumer
receiving => 340628602563041
receiving => 340629608881708
receiving => 340630614753416
receiving => 340631621143666
<ctrl+c>
```

Going forward, we can run many consumer as we want.
```shell
❯ ./producer | ./consumer | ./consumer
receiving => receiving => 340628602563041
receiving => receiving => 340629608881708
receiving => receiving => 340630614753416
receiving => receiving => 340631621143666
<ctrl+c>
```

Also, we can combine any kind of linux command with producer or consumer.

This will print the input value with consumer.
```shell
❯ echo "testing" | ./consumer
receiving => testing
```

This will print last 3 chars from timestamp value.
```shell
❯ ./producer | grep -o '...$'
708
041
541
041
166
<ctrl+c>
```