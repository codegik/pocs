# 🧬 Architecture overview

## 🏛️ Structure

### 1. 🎯 Problem Statement and Context

Food-Co is a food chain, and they're spending too much money using S3 as the main storage. 
They need to reduce the costs, but this must not impact the user experience. 
It should be a smooth migration.


#### Problem space

##### Option 1: Change S3 storage class
- Use S3 if you need low latency or frequent access to your data. Use S3 Glacier for low storage cost, and you do not require millisecond access to your data.
- Both S3 and Glacier are designed for durability of 99.999999999% of objects across multiple Availability Zones.
- **S3 can be used to host static web content, while Glacier cannot.**
- You can run analytics and querying on S3 and Glacier.
- You can configure a life cycle policy for your S3 objects to automatically transfer them to Glacier. You can also upload objects directly to either S3 or Glacier.
- Objects stored in S3 have a minimum storage duration of 30 days (except for S3 Standard). Objects that are archived to Glacier have a minimum 90 days of storage. Objects that are deleted, overwritten, or transitioned to a different storage class before the minimum duration will incur the normal usage charge plus a pro-rated request charge for the remainder of the minimum storage duration.
- We don't need extra refactoring on existing services, we have full compatibility with S3 api.
- We also should have better compressing strategy to reduce bandwidth and storage.

| Storage class or tier                                                  | Expedited            | Standard            | Standard (without Batch) | Bulk            |
|------------------------------------------------------------------------|----------------------|---------------------|--------------------------|-----------------|
| S3 Glacier Flexible Retrieval or S3 Intelligent-Tiering Archive Access | 1–5 minutes          | Minutes–5 hours     | 3–5 hours                | 5–12 hours      |
| S3 Glacier Deep Archive or S3 Intelligent-Tiering Deep Archive Access  | Not available        | 9-12 hours          | Within 12 hours          | Within 48 hours |
|                                                                        |                      |                     |                          |                 |
| Prices                                                                 | $10.00 - 1k requests | $0.05 - 1k requests | $0.05 - 1k requests      | N/A             |


##### Option 2: Use different provider
- ✅ PROS:
    - Low cost of storage.
    - Lower bandwidth costs.
    - Simpler pricing structure.
    - Free egress to CDN. (most cases)
    - S3 Compatible API.
- 🚫 CONS:
    - Lack of connectedness with native services.
    - No event handler to trigger functions. (most cases)
    - Limited number of regions. (some cases)


##### Option 3: Create a custom proxy
- Create a service in front of S3 and other providers. It should request data on a pool of storage providers, if the data doesn't exists on provider A, try get data on provider B, and so on.
- Create a policy to move the data based on access frequent.
    - Frequently accessed files should lives on S3.
    - Files accessed from time to time should lives on secondary provider.
    - Rarely accessed files should lives on cold storage data.


##### Option 4: Use open source tool (Ceph)
- ✅ PROS:
    - Low cost of storage.
    - Open-source: Ceph allows full access to its codebase, promoting maximum customization and adaptability to your specific needs.
- 🚫 CONS:
    - Supporting and maintaining in house.

##### Option 5: Mix of tools

**For image store we can use CDN CloudFront.**
- ✅ PROS:
    - Server side Latency: We can reduce the latency of transferring files to CloudFront since the application is running on AWS.
    - Client side Latency: Faster download speeds and lower latency for your files will result in a significant improvement in customer experience.
- 🚫 CONS:
    - Pricing: High cost at scale, CloudFront pricing is pay-per-use.

**For metadata, we could use open source tool Gluster or Ceph.**
- ✅ PROS:
    - Low cost of storage.
    - Open-source: Gluster/Ceph allows full access to its codebase, promoting maximum customization and adaptability to your specific needs.
    - Latency: The file storage could be installed on an EC2 instance, witch will reduce the latenc£y if compared to using other file storage cloud provider.
- 🚫 CONS:
    - Supporting and maintaining in house.

**For machine learning we could use XPTO TBD.**

##### Use cases & Strategies

We're going to migrate the files from S3 to Gluster by batch process. Once the files are copied, we can remove from S3.

During the copy period, the files will coexist in both places (S3 and Gluster).

After finish the migration, we can point the applications to the new Image Store server.

| Use case                         | Strategy                                                                                                    |
|:---------------------------------|:------------------------------------------------------------------------------------------------------------|
| Consuming files from Image Store | We're going to use open source tool as source (Ceph) of true for images and Nginx as image cache.           |
|                                  | Accessed files will be cached on Nginx directory, and will create a policy to delete older files.           |
|                                  | Users will download the images directly from Nginx.                                                         |
|                                  | Existing applications will consume images from there also.                                                  |
| Adding files to Image Store      | Ceph has API compatible with S3, so existing application would be uploading files to the server as usual.   |
|                                  | Once the file is accessed, it will be cached on Nginx.                                                      |
| Food metadata persistence        | We can have a second Ceph custer to handle only metadata, but we don't need Nginx on front.                 |
|                                  | Users will be able to query or persist food metadata.                                                       |
| Predict consumer order           | We're going to replicate necessary data to Aurora in order to exposes ML models as SQL functions.           |
|                                  | Aurora can call SageMaker or Bedrock for a wide variety of ML algorithms including generative AI.           |
|                                  | Company can predict user orders.                                                                            |
| Tracking existing order          | We will persist order data into Aurora DB, so user could track and see all related data to its orders.      |
| Payment                          | We will persist order data into Aurora DB, so user could see history of payments and payment configuration. |
|                                  |                                                                                                             |


| Reducing costs strategy                                                                                                                                                   |
|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Leverages EC2 hardware environment, making it a cost-effective solution without needing any expensive and extra hardware.                                                 | 
| Data that is accessed frequently can be stored in pools with higher performance settings, whereas archival data can be stored in pools configured for lower-cost storage. |
| Ceph storage pools help control costs is through their inherent data distribution and redundancy mechanisms.                                                              |




### 2. 🎯 Goals

- Reduce storage costs.
- Keep data available for long period of time.
- Smooth migration.
- Caching.
- On demand migration and batch migration.
- Refactor some services in order to consume data from different source, but not changing the existing contracts.

### 3. 🎯 Non-Goals

- API contract updates. 
- Slow down existing system during migration.


### 📐 4. Principles

1. Customer centric.
2. Data availability and integrity. Users should not notice the migration.
3. Observability, expose metrics and logs to enable tracking and monitor anything.
4. Cost-effective, reduce costs and keep the system available.

## 🏗️ 5. Overall Diagrams

### 🗂️ 5.1 Overall architecture

![Overall architecture](overall-architecture.drawio.png "Overall Architecture")

### 🗂️ 5.2 Deployment

![Deployment diagram](deploy-diagram.drawio.png "Deployment diagram")

### 🗂️ 5.3 Use Cases 

#### Image Store

![Storing new images and thumbnails](uc-image-store.png "Storing new images and thumbnails")

![Searching images](uc-search-images.png "Searching images")

#### Creating/Reading Food Metadata

![Creating food metadata](uc-create-food-metadata.png "Creating food metadata")

![Reading food metadata](uc-reading-food-metadata.png "Reading food metadata")

@TODO 

## 🧭 6. Trade-offs

### Major Decisions: 
1. Use Ceph for low storage cost instead of S3, and Ceph has a S3 compatible API.
2. Use Nginx for caching files in front of Ceph.
3. Use SageMaker or Bedrock for a wide variety of ML algorithms including generative AI.

### Tradeoffs:
1. Native mobile vs Cross-platform
    - PROS (+) 
      * Native Apps Have the Best Performance.
      * Native Apps Have Lower Risks of Bugs.
      * Native Apps Receive Fast Updates.
    - CONS (-)
        * Higher Costs Involved With Native Apps
2. EKS vs ECS
   - PROS (+)
     * Reduce latency over the world due multiple availability zones.
   - CONS (-)
     * Operational overhead due responsible for maintaining and operating the worker nodes in your cluster.
3. Cross-region replica vs Single region
   - PROS (+)
     * Minimize latency by maintaining object copies in AWS Regions that are geographically closer to the users.
   - CONS (-)
     * Could have replication lag.
4. Elastic Cache vs Redis
   - PROS (+)
     * Minimize operational overhead due fully managed service for Redis.
   - CONS (-)
     * Higher costs involved with elastic cache

### Websocket security

The WebSocket protocol, RFC 6455, provides a standardized way to establish a full-duplex, two-way communication channel between client and server over a single TCP connection.
It is a different TCP protocol from HTTP but is designed to work over HTTP, using ports 80 and 443 and allowing re-use of existing firewall rules.

WebSockets reuse the same authentication information that is found in the HTTP request when the WebSocket connection is stablished.

More concretely, to ensure a user has authenticated to WebSocket application, all that is necessary is to ensure that we setup a framework that supports authenticate HTTP based web application like Spring Security.

### HTTP security

We're going to use Cognito tool for authenticate and authorize the user.

We should refresh the token every 2 hours o make sure older tokens to not have permission to execute any api.

Any request that requires data from current user, should be authenticated.
API should identify the user by the token provided in the request header.

### 🌏 7. For each key major component

#### 7.1 Incoming message handler

This is an API to send messages from one user to another using WebSocket protocol.
Dates will be collected in backend side, the client should not create dates, only ready dates.

##### Class diagram

![Send message service](send-message-service-class-diagram.drawio.png "Send message service")

##### Contract documentation

Send/receive message event subscription:
```
/v1/message-handler
```

Send message event payload:
```json
{
  "content": "String", // message content
  "to": "String"       // target user that will receive this message
}
```
Server receives the event and send the message to target user represented by field `to`.

Receive message event payload:
```json
{
  "content": "String", // message content
  "from": "String",    // user that sent this message
  "date": "Date"       // message create date (yyy-mm-dd hh:mm:ss)
}
```

#### 7.2 Submitting answer
This is and API to submit the answers for a quiz using HTTP protocol.

Dates will be collected in backend side, the client is should not create dates, only ready dates.

Request
```json
POST /v1/quiz/answer
"user-token": "String"  // authenticated user token header
{
  "quizId": "String",   // unique identification for Quiz
  "answers": ["String"] // array containing all answer ids provided by user
}
```

Response 
```json
HTTP 200
{
  "score": Integer // calculated score based on user answers
}
```

#### 7.3 Listing all games

Any request that requires data from current user, should be authenticated.
API should identify the user by the token provided in the request header.

This API is to retrieve all games from the user.

Request
```json
GET /v1/games
"user-token": "String"  // authenticated user token header
```

Response
```json
HTTP 200
{
  "games": [          // array containing history of games from the user
    {
      "id": "String",   // unique game identifier
      "score": Integer, // calculated score based on user answers 
      "date": "Date"    // game create date (yyy-mm-dd hh:mm:ss)
    }
  ]
}
```


### 🧬 8.0 Algorithms/Data Structures

[//]: # (Spesific algos that need to be used, along size with spesific data structures.)

TBD 


### 💾 9. Migrations

No DB Migration is needed here.

### 🧪 10. Testing strategy

- Unit tests 
  - Will be implemented using JUnit and Mockito.
  - Need to cover most important scenarios and edge cases.
  - This is the first line of defense. It will be running in developer machine and CI/CD pipeline.

- Contract tests
  - It will reduce the chances of one contract change breaks any consumer. The API must be versioned to avoid break backward compatibility and forward compatibility.
  - It will be running in developer machine and CI/CD pipeline.

- Integration tests
  - Not all scenarios should be covered, just most important ones e.g. Submitting quiz answers, Finding a quiz and Sending message to friend.  
  - It will be running in developer machine and CI/CD pipeline right after the build.

- Performance tests
  - Will be implemented using Gatling.
  - It will be running in CI/CD pipeline and pointing to production.

- Chaos tests
  - Test the system's ability to withstand turbulent and unexpected conditions like network latency, server failure, etc.
  - It will be running in CI/CD pipeline and pointing to production.


### 👀 11. Observability strategy (TBD)

[//]: # (Explain the techniques, principles,types of observability that will be used, key metrics, what would be logged and how to design proper dashboards and alerts.)


### 💾 12. Data Store Designs

#### Table ACCOUNTS
| Column    | Type         | Primary | Default             | Observation           |
|-----------|--------------|---------|---------------------|-----------------------|
| id        | varchar(32)  | PK      |                     | unique identification |
| name      | varchar(100) |         |                     | user full name        |
| email     | varchar(200) |         |                     | user email            |
| created_d | date         |         | current_timestamp() |                       |

**Partitioning strategy:** Data partition by list of months based on created date of record.


#### Table USER_ANSWER
| Column     | Type        | Primary | Default             | Observation                      |
|------------|-------------|---------|---------------------|----------------------------------|
| id         | varchar(32) | PK      |                     |                                  |
| account_id | varchar(32) |         |                     | reference id to the user account |
| quiz_id    | varchar(32) |         |                     | reference id to the quiz         |
| answer_id  | varchar(32) |         |                     | reference id to answer           |
| created_d  | date        |         | current_timestamp() |                                  |

**Partitioning strategy:** Data partition by list of months based on created date of record.


#### Table QUIZ
| Column    | Type         | Primary | Default             | Observation |
|-----------|--------------|---------|---------------------|-------------|
| id        | varchar(32)  | PK      |                     |             |
| name      | varchar(200) |         |                     |             |
| question  | blob         |         |                     |             |
| created_d | date         |         | current_timestamp() |             |

**Partitioning strategy:** Data partition by list of months based on created date of record.


#### Table QUIZ_ANSWER
| Column     | Type         | Primary | Default             | Observation |
|------------|--------------|---------|---------------------|-------------|
| id         | varchar(32)  | PK      |                     |             |
| quiz_id    | varchar(32)  |         |                     |             |
| answer     | varchar(500) |         |                     |             |
| is_correct | boolean      |         |                     |             |
| created_d  | date         |         | current_timestamp() |             |

**Partitioning strategy:** Data partition by list of months based on created date of record.


#### Document GAME
```json
{
  "id": "String",
  "account_id": "String", // user account id
  "quiz_id": "String",    // quiz id
  "score": Integer,       // user score on this game
  "created_d": "Date",    // format yyyy-mm-dd hh:mm:ss
  "region": "String"      // user geolocation region
}
```

**Partitioning strategy:** Data partition by list of months based on created date and region of record.


#### Document MESSAGE
```json
{
  "id": "String",
  "from_account_id": "String",  // from user account id (sender)
  "to_account_id": "String",    // to user account id (receiver)
  "content": "String",          // message text
  "created_d": "Date",          // format yyyy-mm-dd hh:mm:ss
  "region": "String"            // user geolocation region
}
```

**Partitioning strategy:** Data partition by list of months based on created date and region of record.


#### Main queries

- Looking for quiz answers (paginated).
```sql
select * from quiz_answer where quiz_id = ?
```

- Getting all messages from chat (paginated).
```sql
select * from message where from_account_id = ? limit ? offset ?
```

- Getting all games from user (paginated).
```sql
select * from games where account_id = ? limit ? offset ?
```


### 👌 13. Technology Stack (WIP)

- Aurora DB as persistence layer for all services besides Message and Game.
- DynamoDB as persistence layer for Message and Game services.
- Kotlin
  -  Clarity:
    - It’s very expressive. Writing code in Kotlin tends to have a high impact per line of code.
    - Kotlin eliminates some of the redundancy in the basic syntax of popular languages like Java.
  - Interoperability:
    - Kotlin interoperates with Java because they compile to the same byte code. Kotlin can be compiled into JavaScript or an LLVM.
    - It also shares tooling with Java. These features make it easy to migrate Java applications to Kotlin.
  - Safety:
    - Kotlin is designed to help avoid common coding errors that can break code or leave vulnerabilities in it. 
    - The language features null safety and eliminating null pointer exception errors.
- Ktor
  - Ktor is designed with simplicity in mind, providing a lean and intuitive API surface.
  - Ktor embraces Kotlin's coroutines, enabling you to write highly efficient and concurrent code effortlessly.
  - Default embedded server application is Netty.


### 👥 14. References

* Architecture Anti-Patterns: https://architecture-antipatterns.tech/
* EIP https://www.enterpriseintegrationpatterns.com/
* SOA Patterns https://patterns.arcitura.com/soa-patterns
* API Patterns https://microservice-api-patterns.org/
* Anti-Patterns https://sourcemaking.com/antipatterns/software-development-antipatterns
* Refactoring Patterns https://sourcemaking.com/refactoring/refactorings
* Database Refactoring Patterns https://databaserefactoring.com/
* Data Modelling Redis https://redis.com/blog/nosql-data-modeling/
* Cloud Patterns https://docs.aws.amazon.com/prescriptive-guidance/latest/cloud-design-patterns/introduction.html
* 12 Factors App https://12factor.net/
* Relational DB Patterns https://www.geeksforgeeks.org/design-patterns-for-relational-databases/
* Rendering Patterns https://www.patterns.dev/vanilla/rendering-patterns/
* REST API Design https://blog.stoplight.io/api-design-patterns-for-rest-web-services



# TODO
- websocket security [DONE]
- no date in payload, it got by backend [DONE]
- two mechanism of transport, should be clear ws vs http  [DONE]
- identify header in payloads  [DONE]
- explain what are those fields in payloads  [DONE]
- what is the most important scenarios, give examples  [DONE]
- what breaks the consumer  [DONE]
- it tests more clear about scenarios  [DONE]
- change format of tables  [DONE]
- add more columns in tables like Rickson [DONE]
- match is reserved word in sql, change to game [DONE]
- write pagination in queries [DONE]
- archive and partitioning below each table [DONE]
- messages should not be in relational db [DONE]
