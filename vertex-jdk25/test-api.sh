se#!/bin/bash

echo "=== Testing Vert.x User CRUD API ==="
echo ""

echo "1. Health Check:"
curl -s http://localhost:8080/health
echo -e "\n"

echo "2. Create User (Alice):"
USER1=$(curl -s -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{"name":"Alice Johnson","email":"alice@example.com"}')
echo "$USER1"
USER1_ID=$(echo "$USER1" | grep -o '"id":"[^"]*"' | cut -d'"' -f4)
echo -e "\n"

echo "3. Create User (Bob):"
USER2=$(curl -s -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{"name":"Bob Smith","email":"bob@example.com"}')
echo "$USER2"
USER2_ID=$(echo "$USER2" | grep -o '"id":"[^"]*"' | cut -d'"' -f4)
echo -e "\n"

echo "4. Get All Users:"
curl -s http://localhost:8080/api/users
echo -e "\n"

echo "5. Get User by ID ($USER1_ID):"
curl -s http://localhost:8080/api/users/$USER1_ID
echo -e "\n"

echo "6. Update User ($USER1_ID):"
curl -s -X PUT http://localhost:8080/api/users/$USER1_ID \
  -H "Content-Type: application/json" \
  -d '{"name":"Alice Williams","email":"alice.williams@example.com"}'
echo -e "\n"

echo "7. Get Updated User ($USER1_ID):"
curl -s http://localhost:8080/api/users/$USER1_ID
echo -e "\n"

echo "8. Delete User ($USER2_ID):"
curl -s -X DELETE http://localhost:8080/api/users/$USER2_ID -w "\nHTTP Status: %{http_code}\n"
echo -e "\n"

echo "9. Try to Get Deleted User ($USER2_ID):"
curl -s http://localhost:8080/api/users/$USER2_ID
echo -e "\n"

echo "10. Get All Users (after deletion):"
curl -s http://localhost:8080/api/users
echo -e "\n"

echo "=== Test Complete ==="
