#!/bin/sh

cd java-opentelemetry
mvn clean install
docker build -t java-opentelemetry .

cd -

cd dotnet-opentelemetry
docker build -t dotnet-opentelemetry .

cd -

docker compose up -d
