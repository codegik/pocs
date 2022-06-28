# H2 in Memory

Using h2 on runtime to simulate edh database. The goal is to enable engineers to test query changes and specific scenarios of data.

## Test

```commandline
./mvnw clean install 
```

## Run

### Start application
```commandline
./mvnw spring-boot:run 
```

### Requesting API example
GET /chargeback/{date}
```commandline
curl --request GET 'http://localhost:8080/chargeback/2022-03-01'
```