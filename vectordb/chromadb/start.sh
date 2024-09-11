#!/bin/zsh

podman rm -f chromadb
podman run -d --name chromadb -p 8000:8000 --env ANONYMIZED_TELEMETRY=False chromadb/chroma

