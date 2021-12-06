/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.flow.reactive;

import co.ivi.jus.shared.Utilities;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
@State(Scope.Thread)
@Fork(3)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
public class ThroughputBench {
    private static Digest messageDigest;
    private static SubmissionPublisher<byte[]> publisher = new SubmissionPublisher<>();

    static {
        Returned<Digest> rt = Digest.of("SHA-256");
        switch (rt) {
            case Returned.ReturnValue rv -> {
                // Get the returned value
                if (rv.returnValue() instanceof Digest d) {
                    messageDigest = d;
                    // Create the transformation processor - the hash function
                    Transform<byte[], byte[]> messageDigest =
                            new Transform<>(d::digest);

                    // Create subscriber for the processor
                    Destination<byte[]> subscriber = new Destination<>(
                            digest -> System.out.println(
                                    "Got message digest: " +
                                            Utilities.toHexString(digest)));

                    // Chain processor and subscriber
                    publisher.subscribe(messageDigest);
                    messageDigest.subscribe(subscriber);
                }
            }
            case Returned.ErrorCode ec -> {
                // blank, unlikely
            }
        };
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
        publisher.submit("Hello, World!".getBytes());
    }
}
