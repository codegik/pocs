package com.codegik.poc.jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.Random;
import java.util.concurrent.TimeUnit;


@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Fork(value = 1, warmups = 1)
public class StringBench {

    @Param({"1000000"})
    int iterations;

    @Benchmark
    public String usingStringConcatenation() {
        String s = String.valueOf(new Random().nextLong());

        for (int i = 0; i < iterations; i++) {
            s = s + new Random().nextLong();
        }

        return s;
    }


    @Benchmark
    public String usingStringBufferConcatenation() {
        StringBuffer s = new StringBuffer();
        s.append(new Random().nextLong());

        for (int i = 0; i < iterations; i++) {
            s.append(new Random().nextLong());
        }

        return s.toString();
    }
}
