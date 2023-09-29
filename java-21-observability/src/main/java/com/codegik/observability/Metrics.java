package com.codegik.observability;


import java.util.Map;
import java.util.function.Supplier;

public final class Metrics {
    private static Metrics instance;
    private Counter counter;


    private Metrics() {
        this.counter = new Counter();
    }


    public static Metrics metrics() {
        if (instance == null) {
            instance = new Metrics();
        }
        return instance;
    }


    public static <T> T measureLatency(String operation, Supplier<T> func) {
        var startTime = System.currentTimeMillis();
        try {
            var result = func.get();
            metrics().counter.registerSuccess(operation);
            return result;
        } catch (Exception e) {
            metrics().counter.registerError(operation);
            throw e;
        } finally {
            metrics().counter.registerLatency(operation, startTime);
        }
    }


    public static Map<String, Long> metricsMap() {
        return metrics().counter.getMetricMap();
    }


    public static boolean reset() {
        return metrics().counter.reset();
    }

}
