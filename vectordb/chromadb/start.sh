#!/bin/zsh

podman rm -f chromadb
podman rm -f chromadb-admin

podman run -d --name chromadb -p 8000:8000 --env ANONYMIZED_TELEMETRY=False chromadb/chroma
podman run -d --name chromadb-admin -p 3000:3000 fengzhichao/chromadb-admin


