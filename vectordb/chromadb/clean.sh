#!/bin/zsh

./stop.sh

podman rmi chromadb/chroma
podman rmi fengzhichao/chromadb-admin
