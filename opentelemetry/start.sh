#!/bin/sh

cd java-opentelemetry
#mvn clean install
docker build -t java-opentelemetry .

cd -

docker compose up -d
