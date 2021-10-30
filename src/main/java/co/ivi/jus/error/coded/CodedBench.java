/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.error.coded;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

// Benchmark                  Mode  Cnt           Score          Error  Units
// CodedBench.noErrorCode    thrpt   15  1294683223.721 ± 52780816.883  ops/s
// CodedBench.withErrorCode  thrpt   15  1020513332.336 ±  5557838.495  ops/s

// Benchmark                  Mode  Cnt           Score          Error  Units
// CodedBench.noErrorCode    thrpt   15  1320977784.955 ±  7487395.023  ops/s
// CodedBench.withErrorCode  thrpt   15  1068513642.240 ± 69527558.874  ops/s

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
@State(Scope.Thread)
@Fork(3)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
public class CodedBench {
    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(CodedBench.class.getSimpleName())
                .forks(3)
                .warmupIterations(5)
                .measurementIterations(5)
                .build();

        new Runner(options).run();
    }

    @Benchmark
    public void withErrorCode() {
          Digest.of("SHA-128");
    }

    @Benchmark
    public void noErrorCode() {
          Digest.of("SHA-256");
    }
}
