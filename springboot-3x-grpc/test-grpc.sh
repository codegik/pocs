#!/bin/bash

# Spring Boot gRPC CRUD Test Script
# This script demonstrates how to test the gRPC CRUD operations using grpcurl

set -e  # Exit on error

echo "=== Spring Boot gRPC CRUD API Test ==="
echo ""

# Check if grpcurl is installed
if ! command -v grpcurl &> /dev/null; then
    echo "grpcurl is not installed. Install it with:"
    echo "  go install github.com/fullstorydev/grpcurl/cmd/grpcurl@latest"
    echo ""
    echo "Or on macOS: brew install grpcurl"
    echo "Or on Linux: Download from https://github.com/fullstorydev/grpcurl/releases"
    exit 1
fi

# Function to cleanup on exit
cleanup() {
    if [ ! -z "$APP_PID" ]; then
        echo ""
        echo "Stopping Spring Boot application (PID: $APP_PID)..."
        kill $APP_PID 2>/dev/null || true
        wait $APP_PID 2>/dev/null || true
        echo "Application stopped."
    fi
}

# Register cleanup function to run on exit
trap cleanup EXIT INT TERM

# Start the Spring Boot application
echo "Starting Spring Boot application..."
cd "$(dirname "$0")"
source ~/.sdkman/bin/sdkman-init.sh
sdk use java 25.0.1-amzn
mvn spring-boot:run > /tmp/grpc-app.log 2>&1 &
APP_PID=$!

echo "Application started with PID: $APP_PID"
echo "Waiting for application to be ready..."

# Wait for the application to start (check port 9090)
MAX_WAIT=60
WAIT_COUNT=0
while ! nc -z localhost 9090 2>/dev/null; do
    if [ $WAIT_COUNT -ge $MAX_WAIT ]; then
        echo "ERROR: Application failed to start within ${MAX_WAIT} seconds"
        echo "Check logs at /tmp/grpc-app.log"
        tail -50 /tmp/grpc-app.log
        exit 1
    fi
    sleep 1
    WAIT_COUNT=$((WAIT_COUNT + 1))
    echo -n "."
done

echo ""
echo "Application is ready!"
echo ""
echo "Testing gRPC server on localhost:9090"
echo ""

# List available services
echo "1. Listing available services:"
grpcurl -plaintext localhost:9090 list
echo ""

# List methods for UserService
echo "2. Listing methods for UserService:"
grpcurl -plaintext localhost:9090 list user.UserService
echo ""

# Create a user
echo "3. Creating a new user (John Doe):"
grpcurl -plaintext -d '{"name": "John Doe", "email": "john@example.com"}' \
  localhost:9090 user.UserService/CreateUser
echo ""

# Create another user
echo "4. Creating another user (Jane Smith):"
grpcurl -plaintext -d '{"name": "Jane Smith", "email": "jane@example.com"}' \
  localhost:9090 user.UserService/CreateUser
echo ""

# Get user by ID
echo "5. Getting user with ID 1:"
grpcurl -plaintext -d '{"id": 1}' \
  localhost:9090 user.UserService/GetUser
echo ""

# List all users
echo "6. Listing all users:"
grpcurl -plaintext -d '{}' \
  localhost:9090 user.UserService/ListUsers
echo ""

# Update user
echo "7. Updating user with ID 1:"
grpcurl -plaintext -d '{"id": 1, "name": "John Updated", "email": "john.updated@example.com"}' \
  localhost:9090 user.UserService/UpdateUser
echo ""

# Get updated user
echo "8. Getting updated user with ID 1:"
grpcurl -plaintext -d '{"id": 1}' \
  localhost:9090 user.UserService/GetUser
echo ""

# Delete user
echo "9. Deleting user with ID 1:"
grpcurl -plaintext -d '{"id": 1}' \
  localhost:9090 user.UserService/DeleteUser
echo ""

# List all users after deletion
echo "10. Listing all users after deletion:"
grpcurl -plaintext -d '{}' \
  localhost:9090 user.UserService/ListUsers
echo ""

echo "=== Test completed ==="
