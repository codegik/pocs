#!/bin/zsh

podman rm -f chromadb
podman rm -f chromadb-admin
podman rmi chromadb/chroma
podman rmi fengzhichao/chromadb-admin
