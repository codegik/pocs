#!/bin/bash

BASE_URL="http://localhost:8080"

echo "Testing Correlation ID Propagation in Spring WebFlux"
echo "===================================================="
echo ""

echo "Test 1: Create user WITHOUT correlation ID header (should generate one)"
echo "------------------------------------------------------------------------"
RESPONSE=$(curl -s -i -X POST "$BASE_URL/api/users" \
  -H "Content-Type: application/json" \
  -d '{"name":"Alice","email":"alice@test.com"}')
echo "$RESPONSE"
CORRELATION_ID=$(echo "$RESPONSE" | grep -i "X-Correlation-Id" | cut -d' ' -f2 | tr -d '\r')
echo ""
echo "Generated Correlation ID: $CORRELATION_ID"
echo ""
echo ""

echo "Test 2: Create user WITH custom correlation ID header"
echo "------------------------------------------------------"
CUSTOM_ID="test-correlation-12345"
RESPONSE=$(curl -s -i -X POST "$BASE_URL/api/users" \
  -H "Content-Type: application/json" \
  -H "X-Correlation-Id: $CUSTOM_ID" \
  -d '{"name":"Bob","email":"bob@test.com"}')
echo "$RESPONSE"
echo ""
echo "Custom Correlation ID used: $CUSTOM_ID"
echo ""
echo ""

echo "Test 3: Get all users with another custom correlation ID"
echo "---------------------------------------------------------"
ANOTHER_ID="list-users-67890"
RESPONSE=$(curl -s -i -X GET "$BASE_URL/api/users" \
  -H "X-Correlation-Id: $ANOTHER_ID")
echo "$RESPONSE"
echo ""
echo ""

echo "Test 4: Parallel requests with different correlation IDs"
echo "---------------------------------------------------------"
curl -s -X POST "$BASE_URL/api/users" \
  -H "Content-Type: application/json" \
  -H "X-Correlation-Id: parallel-request-001" \
  -d '{"name":"Charlie","email":"charlie@test.com"}' &

curl -s -X POST "$BASE_URL/api/users" \
  -H "Content-Type: application/json" \
  -H "X-Correlation-Id: parallel-request-002" \
  -d '{"name":"Diana","email":"diana@test.com"}' &

curl -s -X POST "$BASE_URL/api/users" \
  -H "Content-Type: application/json" \
  -H "X-Correlation-Id: parallel-request-003" \
  -d '{"name":"Eve","email":"eve@test.com"}' &

wait
echo "Parallel requests completed"
echo ""
echo ""

echo "Check application logs to see correlation IDs in action!"
echo "Look for patterns like: [correlation-id] in the log output"
