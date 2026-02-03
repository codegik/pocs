#!/bin/bash

# Cleanup function to kill the app on exit
cleanup() {
    if [ ! -z "$APP_PID" ]; then
        echo ""
        echo "=== Stopping Application (PID: $APP_PID) ==="
        kill $APP_PID 2>/dev/null
        wait $APP_PID 2>/dev/null
        echo "Application stopped."
    fi
}

# Set trap to ensure cleanup happens on script exit
trap cleanup EXIT INT TERM

# Kill any existing application on port 8080
echo "=== Checking for existing application ==="
EXISTING_PID=$(lsof -ti:8080 2>/dev/null)
if [ ! -z "$EXISTING_PID" ]; then
    echo "Found existing application on port 8080 (PID: $EXISTING_PID)"
    echo "Killing existing application..."
    kill $EXISTING_PID 2>/dev/null
    sleep 2
    # Force kill if still running
    if kill -0 $EXISTING_PID 2>/dev/null; then
        echo "Force killing..."
        kill -9 $EXISTING_PID 2>/dev/null
    fi
    echo "Existing application stopped."
fi

echo "=== Starting Vert.x Application ==="
mvn exec:java > /tmp/vertx-app.log 2>&1 &
APP_PID=$!
echo "Application started with PID: $APP_PID"

# Wait for application to be ready
echo "Waiting for application to start..."
MAX_RETRIES=30
RETRY_COUNT=0
while [ $RETRY_COUNT -lt $MAX_RETRIES ]; do
    if curl -s http://localhost:8080/health > /dev/null 2>&1; then
        echo "Application is ready!"
        break
    fi
    RETRY_COUNT=$((RETRY_COUNT + 1))
    if [ $RETRY_COUNT -eq $MAX_RETRIES ]; then
        echo "ERROR: Application failed to start within 30 seconds"
        echo "Log output:"
        cat /tmp/vertx-app.log
        exit 1
    fi
    sleep 1
    echo -n "."
done
echo ""

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
