<img height="200" src="images/img.png" width="200"/>

# Prometheus

#### 1. Store metrics and performance data
#### 2. Pulling approach
#### 3. Time series DB
#### 4. Companies using
![img_1.png](images/img_1.png)

#### 5. Integrations
![img_2.png](images/img_2.png)

#### 6. Advantages
- Easy to setup and create alerts
- Multi-dimensional data model
- No dependency on distributed storage

#### 7. Drawbacks
- Requires multiple tools to compensate the poor UI
- Only for metrics
- Written in Go

## Demo stack = Kotlin + Spring-boot + Prometheus

#### Requirements
- Java 17
- Gradle
- Docker

#### Running and testing

1 - Start everything: spring-boot app + prometheus
```
./start.sh
```

2 - Shutting down the application
```
./app-stop.sh
```

3 - Start the application
```
./app-start.sh
```

4 - Stop everything
```
./stop.sh
```
