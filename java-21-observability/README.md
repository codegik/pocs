# Observability framework

Observability core framework based on latency metrics.

## Requirements

- Java 17
- Maven 3

## Run

```shell
mvn clean install
```

## Example 1

We can collect metrics from function execution and return the caller's result.

```java
var result = measureLatency("myoperation", () -> {
    sleep(4);
    return "returned from caller's function";
});

var metricsMap = metricsMap();
System.out.println("total " + metricsMap.get("myoperation.latency.total"));
System.out.println("errors " + metricsMap.get("myoperation.latency.errors"));
System.out.println("success " + metricsMap.get("myoperation.latency.success"));
System.out.println("avg " + metricsMap.get("myoperation.latency.avg"));
```

Output
```shell
total 1
errors 0
success 1
avg 6
```

## Example 2

Collect metrics even when caller's function throws exceptions.

```java
measureLatency("anything", () -> {
    sleep(4);
    throw new RuntimeException("any exception");
});

var metricsMap = metricsMap();
System.out.println("total " + metricsMap.get("anything.latency.total"));
System.out.println("errors " + metricsMap.get("anything.latency.errors"));
System.out.println("success " + metricsMap.get("anything.latency.success"));
System.out.println("avg " + metricsMap.get("anything.latency.avg"));
```

Output
```shell
total 1
errors 1
success 0
avg 6
```