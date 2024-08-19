#!/bin/zsh

PID=$(ps -e -o pid,comm,args | grep -v "grep" |grep "kotlin-netty-metrics-0.0.1-SNAPSHOT.jar" |awk '{print $1}')
echo "===> killing app PID $PID"
kill -9 $PID