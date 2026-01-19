#!/bin/bash

# Spring Boot gRPC CRUD Test Script
# This script demonstrates how to test the gRPC CRUD operations using grpcurl

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
