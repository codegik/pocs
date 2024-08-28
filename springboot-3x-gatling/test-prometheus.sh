#!/bin/bash

ACTUATOR_URL="http://localhost:8280/actuator"
PROMETHEUS_URL="http://localhost:8280"
TMP_FILE="/tmp/test.output"

echo "Metric|Actuator|Prometheus" > $TMP_FILE

COUNT1=$(curl -s "$ACTUATOR_URL/metrics/http.client.requests" | jq '.measurements[] | select(.statistic=="COUNT") | first(.value)')
COUNT2=$(curl -s "$PROMETHEUS_URL/metrics?includedNames=http_client_requests_seconds" |grep "_count" |awk '{sum+=$2;}END{print sum}')

echo "executor.pool.size|$COUNT1|$COUNT2" >> $TMP_FILE

COUNT1=$(curl -s "$ACTUATOR_URL/metrics/reactor.netty.eventloop.pending.tasks" | jq '.measurements[] | first(.value)')
COUNT2=$(curl -s "$PROMETHEUS_URL/metrics?includedNames=reactor_netty_eventloop_pending_tasks" |grep "name=" |awk '{sum+=$2;}END{print sum}')

echo "reactor.netty.eventloop.pending.tasks|$COUNT1|$COUNT2" >> $TMP_FILE

COUNT1=$(curl -s "$ACTUATOR_URL/metrics/http.server.requests" | jq '.measurements[] | select(.statistic=="COUNT") | first(.value)')
COUNT2=$(curl -s "$PROMETHEUS_URL/metrics?includedNames=http_server_requests_seconds" |grep "_count" |awk '{sum+=$2;}END{print sum-1}')

echo "http.server.requests|$COUNT1|$COUNT2" >> $TMP_FILE

cat $TMP_FILE | column -t -s "|"
