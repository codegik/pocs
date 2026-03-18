#!/bin/bash

set -e

cleanup() {
  if [ ! -z "$APP_PID" ]; then
    kill -TERM $APP_PID 2>/dev/null || true
    sleep 1
    kill -9 $APP_PID 2>/dev/null || true
    wait $APP_PID 2>/dev/null || true
  fi
}

trap cleanup EXIT INT TERM

echo "Compiling application..."
sbt compile

echo "Starting application..."
sbt "runMain ServerRunner" > /tmp/server.log 2>&1 &
APP_PID=$!

echo "Waiting for application to be ready..."
MAX_WAIT=60
ELAPSED=0
while ! curl -s http://localhost:8080/health > /dev/null 2>&1; do
  if [ $ELAPSED -ge $MAX_WAIT ]; then
    echo "Application failed to start within ${MAX_WAIT}s"
    cat /tmp/server.log
    exit 1
  fi
  if ! kill -0 $APP_PID 2>/dev/null; then
    echo "Application process died"
    cat /tmp/server.log
    exit 1
  fi
  sleep 1
  ELAPSED=$((ELAPSED + 1))
done

echo "Application is ready"

echo "Running tests..."
sbt test

echo "Tests completed successfully"

echo "Terminating application..."
kill -TERM $APP_PID 2>/dev/null || true
sleep 1
kill -9 $APP_PID 2>/dev/null || true
wait $APP_PID 2>/dev/null || true
APP_PID=""

echo "Done"
