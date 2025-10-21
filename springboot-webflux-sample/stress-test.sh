#!/bin/bash

ENDPOINT=${1:-"http://localhost:8080/api/users"}
CONCURRENT=${2:-50}
REQUESTS=${3:-1000}

echo "Stress testing endpoint: $ENDPOINT"
echo "Concurrent requests: $CONCURRENT"
echo "Total requests: $REQUESTS"
echo ""

seq 1 $REQUESTS | xargs -P $CONCURRENT -I {} curl -k -s -o /dev/null -w "%{http_code}\n" $ENDPOINT | sort | uniq -c

echo ""
echo "Stress test completed"

