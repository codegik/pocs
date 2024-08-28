#!/bin/bash

URL="http://localhost:8280/actuator"

echo "                   executor.pool.size $(curl -s "$URL/metrics/executor.pool.size" | jq '.measurements[] | first(.value)')"
echo "                      executor.active $(curl -s "$URL/metrics/executor.active" | jq '.measurements[] | first(.value)')"
echo "                   executor.pool.core $(curl -s "$URL/metrics/executor.pool.core" | jq '.measurements[] | first(.value)')"
echo "                   executor.completed $(curl -s "$URL/metrics/executor.completed" | jq '.measurements[] | first(.value)')"
echo "                      executor.queued $(curl -s "$URL/metrics/executor.queued" | jq '.measurements[] | first(.value)')"
echo "                        executor.idle $(curl -s "$URL/metrics/executor.idle" | jq '.measurements[] | select(.statistic=="COUNT") | first(.value)')"
echo "             executor.queue.remaining $(curl -s "$URL/metrics/executor.queue.remaining" | jq '.measurements[] | first(.value)')"
echo "              executor.scheduled.once $(curl -s "$URL/metrics/executor.scheduled.once" | jq '.measurements[] | first(.value)')"
echo "      executor.scheduled.repetitively $(curl -s "$URL/metrics/executor.scheduled.repetitively" | jq '.measurements[] | first(.value)')"
echo "                 http.server.requests $(curl -s "$URL/metrics/http.server.requests" | jq '.measurements[] | select(.statistic=="COUNT") | first(.value)')"
echo "          http.server.requests.active $(curl -s "$URL/metrics/http.server.requests.active" | jq '.measurements[] | select(.statistic=="ACTIVE_TASKS") | first(.value)')"
echo "reactor.netty.eventloop.pending.tasks $(curl -s "$URL/metrics/reactor.netty.eventloop.pending.tasks" | jq '.measurements[] | first(.value)')"
