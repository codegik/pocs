# Infrastructure in Java + App in Node

This is an POC to setup infrastructure managed by java, and deploy node application using docker.

## Requirements

- Java 17
- Gradle
- Docker

## Setup

For MacOS users, the docker host address might be different. In my local machine, the docker host is:
```
unix:///Users/iklassman/.docker/run/docker.sock
```

So its necessary to configure docker host in pulumi running these commands:
```
export DOCKER_HOST=unix:///Users/iklassman/.docker/run/docker.sock

pulumi config set docker:host unix:///Users/iklassman/.docker/run/docker.sock
```

Configuring the containers
```
pulumi config set frontendPort 3001
pulumi config set backendPort 3000
pulumi config set mongoPort 27017
pulumi config set mongoHost mongodb://mongo:27017
pulumi config set database cart
pulumi config set nodeEnvironment development
pulumi config set protocol http://
```