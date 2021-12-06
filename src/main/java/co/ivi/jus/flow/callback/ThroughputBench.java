/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.flow.callback;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
@State(Scope.Thread)
@Fork(3)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
public class ThroughputBench {
    private static Digest messageDigest;

    static {
        Digest.of("SHA-256",
                md -> messageDigest = md,
                errorCode -> {
                    // blank, unlikely
                }
        );
    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(ThroughputBench.class.getSimpleName())
                .forks(3)
                .warmupIterations(5)
                .measurementIterations(5)
                .build();

        new Runner(options).run();
    }

    @Benchmark
    public void simpleDigest() {
        messageDigest.digest("Hello, world!".getBytes(),
                values -> {
                    // blank, no use
                },
                errorCode -> {
                    // blank, unlikely
                });
    }
}
