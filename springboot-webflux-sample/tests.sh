#!/bin/bash

echo "Creating user 1"
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{"name":"John Doe","email":"john@test.com"}'

echo ""
echo "Creating user 2"
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{"name":"Jane Smith","email":"jane@test.com"}'

echo ""
echo "Listing all users"
curl -X GET http://localhost:8080/api/users

echo ""
echo "Getting user by ID (replace USER_ID with actual ID from previous response)"
curl -X GET http://localhost:8080/api/users/USER_ID

echo ""
echo "Getting all metrics"
curl -X GET http://localhost:8080/actuator/metrics

echo ""
echo "Getting Netty connection provider metrics"
curl -X GET http://localhost:8080/actuator/metrics/reactor.netty.connection.provider.total.connections

echo ""
echo "Getting Netty bytebuf allocator metrics"
curl -X GET http://localhost:8080/actuator/metrics/reactor.netty.bytebuf.allocator.used.heap.memory

echo ""
echo "Getting Prometheus metrics (includes all Netty metrics)"
curl -X GET http://localhost:8080/actuator/prometheus | grep reactor_netty

echo ""
echo "Testing blocking endpoint to create pending tasks on event loop"
curl -X GET http://localhost:8080/api/block &
sleep 1
echo ""
echo "Getting event loop pending tasks while blocked"
curl -X GET http://localhost:8080/actuator/metrics/reactor.netty.eventloop.pending.tasks
