package com.codegik.observability;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

class Counter {
    private Map<String, Long> totalCounter = new ConcurrentHashMap();
    private Map<String, Long> successCounter = new ConcurrentHashMap();
    private Map<String, Long> errorCounter = new ConcurrentHashMap();
    private Map<String, Long> cumulativeDuration = new ConcurrentHashMap();
    private Map<String, Long> durationAvg = new ConcurrentHashMap();
    private Map<String, Long> durationP50 = new ConcurrentHashMap();
    private Map<String, Long> durationP90 = new ConcurrentHashMap();
    private Map<String, Long> durationP99 = new ConcurrentHashMap();
    private Map<String, Set<Long>> durationHistory = new ConcurrentHashMap<>();


    Long registerLatency(String operation, Long startTime) {
        var duration = System.currentTimeMillis() - startTime;
        var currDuration = cumulativeDuration.computeIfAbsent(operation, value -> 0L) + duration;
        var currCount = totalCounter.computeIfAbsent(operation, value -> 0L) + 1L;
        var currHistory = durationHistory.computeIfAbsent(operation, value -> new TreeSet<>());

        currHistory.add(duration);
        durationHistory.put(operation, currHistory);
        cumulativeDuration.put(operation, currDuration);
        totalCounter.put(operation, currCount);
        durationAvg.put(operation, currDuration / currCount);

        var orderedHistory = new ArrayList<>(currHistory);
        var p50Index = (int) (currHistory.size() * 0.5);
        var p90Index = (int) (currHistory.size() * 0.9);
        var p99Index = (int) (currHistory.size() * 0.99);

        durationP50.put(operation, orderedHistory.get(p50Index));
        durationP90.put(operation, orderedHistory.get(p90Index));
        durationP99.put(operation, orderedHistory.get(p99Index));

        return duration;
    }


    Long registerSuccess(String operation) {
        var count = successCounter.computeIfAbsent(operation, v -> 0L) + 1;
        successCounter.put(operation, count);
        return count;
    }


    Long registerError(String operation) {
        var count = errorCounter.computeIfAbsent(operation, v -> 0L) + 1;
        errorCounter.put(operation, count);
        return count;
    }


    boolean reset() {
        totalCounter.clear();
        successCounter.clear();
        errorCounter.clear();
        cumulativeDuration.clear();
        durationAvg.clear();

        return true;
    }


    Map<String, Long> getMetricMap() {
        var result = new HashMap<String, Long>();

        for (String operation : totalCounter.keySet()) {
            result.put(operation + ".latency.avg", durationAvg.computeIfAbsent(operation, v -> 0L));
            result.put(operation + ".latency.total", totalCounter.computeIfAbsent(operation, v -> 0L));
            result.put(operation + ".latency.success", successCounter.computeIfAbsent(operation, v -> 0L));
            result.put(operation + ".latency.errors", errorCounter.computeIfAbsent(operation, v -> 0L));
            result.put(operation + ".latency.p50", durationP50.computeIfAbsent(operation, v -> 0L));
            result.put(operation + ".latency.p90", durationP90.computeIfAbsent(operation, v -> 0L));
            result.put(operation + ".latency.p99", durationP99.computeIfAbsent(operation, v -> 0L));
        }

        return result;
    }
}
