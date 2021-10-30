/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.error.former;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

// Benchmark                        Mode  Cnt          Score          Error  Units
// OutOfBoundsBench.noException    thrpt   15  531217144.697 ± 88633850.663  ops/s
// OutOfBoundsBench.withException  thrpt   15     561648.779 ±    28430.340  ops/s

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
@State(Scope.Thread)
@Fork(3)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
public class OutOfBoundsBench {
    private static String s = "Hello, world!";  // s.length() == 13.

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(OutOfBoundsBench.class.getSimpleName())
                .forks(3)
                .warmupIterations(5)
                .measurementIterations(5)
                .build();

        new Runner(options).run();
    }

    @Benchmark
    public void withException() {
        try {
            s.substring(14);
        } catch (RuntimeException re) {
            // blank line, ignore the exception.
        }
    }

    @Benchmark
    public void noException() {
        try {
            s.substring(13);
        } catch (RuntimeException re) {
            // blank line, ignore the exception.
        }
    }
}
