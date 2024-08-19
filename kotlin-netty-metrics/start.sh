#!/bin/zsh

podman-compose up -d
./mvnw clean package
./app-start.sh
