#!/bin/sh

docker compose down
helm repo remove signoz
kind delete cluster
rm -rf java-opentelemetry/target
