# Signoz: Open Telemetry POC

This is a POC for studying purpose.

Basically, I'm running more than one application using different technologies, and sending metrics to Signoz.

## Requirements
- Java 21
- Maven 3
- Docker
- Docker Compose
- Kind
- Helm
- Kubectl

## Configuring

Need to run only once.

```shell
./config.sh
```

Wait until all pods get started. You can check running this command.

```shell
kubectl -n platform get pods
```


## Start application 
```shell
./start.sh
```

## Stop application
```shell
./stop.sh
```

## Clean up

This command will destroy k8s cluster.

```shell
./clean.sh
```