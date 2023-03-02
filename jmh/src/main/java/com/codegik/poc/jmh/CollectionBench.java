package com.codegik.poc.jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
@Measurement(iterations = 5, time = 10)
@Warmup(iterations = 1)
@Fork(value = 1, warmups = 1)
public class CollectionBench {
    private String none = "none";
    private String first = "first";
    private String last = "last";

    private List<String> array = Arrays.asList(none, first, last);
    private ArrayList arrayList = new ArrayList(array);
    private HashSet hashSet = new HashSet(array);
    private List immutableList = array;
    private Set immutableSet = Collections.unmodifiableSet(new HashSet(array));


    @Benchmark
    public boolean arrayListContainsLast() {
        return arrayList.contains(last);
    }

    @Benchmark
    public boolean hashSetListContainsLast() {
        return hashSet.contains(last);
    }

    @Benchmark
    public boolean immutableListContainsLast() {
        return immutableList.contains(last);
    }

    @Benchmark
    public boolean immutableSetContainsLast() {
        return immutableSet.contains(last);
    }

}
