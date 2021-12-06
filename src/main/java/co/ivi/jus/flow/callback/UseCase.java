/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.flow.callback;

public class UseCase {
    public static void main(String[] args) {
        Digest.of("SHA-256",
            md -> {
                System.out.println("SHA-256 is not supported");
                md.digest("Hello, world!".getBytes(),
                    values -> {
                        System.out.println("SHA-256 is available");
                    },
                    errorCode -> {
                        System.out.println("SHA-256 is not available");
                    });
            },
            errorCode -> {
                System.out.println("Unsupported algorithm: SHA-256");
            });
    }
}
