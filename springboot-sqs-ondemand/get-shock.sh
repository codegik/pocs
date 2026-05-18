#!/bin/bash

SOCKET_PATH=""

if command -v /opt/homebrew/bin/podman &> /dev/null; then
    SOCKET_PATH=$(/opt/homebrew/bin/podman machine inspect --format '{{.ConnectionInfo.PodmanSocket.Path}}' 2>/dev/null)
elif command -v podman &> /dev/null; then
    SOCKET_PATH=$(podman machine inspect --format '{{.ConnectionInfo.PodmanSocket.Path}}' 2>/dev/null)
fi

if [ -n "$SOCKET_PATH" ] && [ -S "$SOCKET_PATH" ]; then
    echo "$SOCKET_PATH"
elif [ -S /var/run/docker.sock ]; then
    echo "/var/run/docker.sock"
fi
