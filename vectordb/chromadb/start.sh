#!/bin/zsh

./stop.sh

podman run -d --name chromadb -p 8000:8000 --env ANONYMIZED_TELEMETRY=False chromadb/chroma
podman run -d --name chromadb-admin -p 3000:3000 fengzhichao/chromadb-admin


