/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.stack.callback;

import java.util.concurrent.atomic.AtomicBoolean;

public class UseCase {
    public static void main(String[] args) {
        // SHA-128, SHA-256, SHA-192, SHA-512
        String[] algorithms = {"SHA-128", "SHA-512"};

        AtomicBoolean foundIt = new AtomicBoolean(false);
        for (String algorithm : algorithms) {
            Digest.of(algorithm,
                    md -> {
                        foundIt.set(true);
                        md.digest("Hello, world!".getBytes(),
                                values -> System.out.println("There is an available hash algorithm."),
                                errorCode -> {
                                    // ignore, but check out the failure stack
                                    new RuntimeException("Failed digest algorithm").printStackTrace(System.out);
                                });
                    },
                    errorCode -> {
                        // ignore
                    });
            if (foundIt.get()) {
                break;
            }
        }

        if (!foundIt.get()) {
            throw new RuntimeException("No available hash algorithm");
        }
    }
}
