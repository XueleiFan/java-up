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

import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

// Benchmark                      Mode  Cnt           Score          Error  Units
// ExceptionBench.noException    thrpt   15  1168332489.381 ± 99596462.126  ops/s
// ExceptionBench.withException  thrpt   15      698594.835 ±    20852.034  ops/s

// Benchmark                      Mode  Cnt           Score          Error  Units
// ExceptionBench.noException    thrpt   15  1318854854.577 ± 14522418.634  ops/s
// ExceptionBench.withException  thrpt   15      713057.511 ±    16631.048  ops/s

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
@State(Scope.Thread)
@Fork(3)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
public class ExceptionBench {
    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(ExceptionBench.class.getSimpleName())
                .forks(3)
                .warmupIterations(5)
                .measurementIterations(5)
                .build();

        new Runner(options).run();
    }

    @Benchmark
    public void withException() {
        try {
            Digest.of("SHA-128");
        } catch (NoSuchAlgorithmException nsae) {
            // blank line, ignore the exception.
        }
    }

    @Benchmark
    public void noException() {
        try {
            Digest.of("SHA-256");
        } catch (NoSuchAlgorithmException nsae) {
            // blank line, ignore the exception.
        }
    }
}
