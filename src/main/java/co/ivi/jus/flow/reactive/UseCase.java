/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.flow.reactive;

import co.ivi.jus.shared.Utilities;

import java.util.concurrent.SubmissionPublisher;
import java.util.function.Function;

public class UseCase {
    public static void main(String[] args) throws InterruptedException {
        Returned<Digest> rt = Digest.of("SHA-256");
        switch (rt) {
            case Returned.ReturnValue rv -> {
                // Get the returned value
                if (rv.returnValue() instanceof Digest d) {
                    // Call the transform method for the message digest.
                    transform("Hello, World!".getBytes(), d::digest);

                    // Wait for completion
                    Thread.sleep(20000);
                } else {  // unlikely
                    System.out.println("Implementation error: SHA-256");
                }
            }
            case Returned.ErrorCode ec ->
                    System.out.println("Unsupported algorithm: SHA-256");
        }
    }

    private static void transform(byte[] message,
              Function<byte[], byte[]> transformFunction) {
        SubmissionPublisher<byte[]> publisher =
                new SubmissionPublisher<>();

        // Create the transform processor
        Transform<byte[], byte[]> messageDigest =
                new Transform<>(transformFunction);

        // Create subscriber for the processor
        Destination<byte[]> subscriber = new Destination<>(
                values -> System.out.println(
                        "Got it: " + Utilities.toHexString(values)));

        // Chain processor and subscriber
        publisher.subscribe(messageDigest);
        messageDigest.subscribe(subscriber);

        publisher.submit(message);
        publisher.close();
    }
}
