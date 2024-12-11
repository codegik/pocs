#!/bin/sh

PIDS=$(ps -e -o pid,comm,args | grep -v "grep" |grep "node index.js" |awk '{print $1}')
PIDS=$(echo $PIDS | tr '\n' ' ')
echo "===> killing app PID $PIDS"
kill -9 $PIDS

echo "===> stoping container"
docker stop envoy
