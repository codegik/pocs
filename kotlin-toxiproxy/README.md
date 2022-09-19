# Toxiproxy POC

## Requirements
- Java 17
- Maven 3
- Toxiproxy Server

## Mysql proxy

### Initialize Mysql and toxiproxy server
```
$ docker run --rm --name mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -p 3306:3306 -d mysql:8
$ toxiproxy-server
```
### Run the app
```
$ mvn compile exec:java
```

### Stop the container and toxiproxy server
```
$ docker stop mysql
$ killall toxiproxy-server
```
