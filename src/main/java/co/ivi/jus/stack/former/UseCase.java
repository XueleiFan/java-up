/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.stack.former;

import java.security.NoSuchAlgorithmException;

public class UseCase {
    public static void main(String[] args) {
        String[] algorithms = {"SHA-128", "SHA-192"};

        String availableAlgorithm = null;
        for (String algorithm : algorithms) {
            Digest md;
            try {
                md = Digest.of(algorithm);
            } catch (NoSuchAlgorithmException ex) {
                // ignore, continue to use the next algorithm.
                continue;
            }

            try {
                md.digest("Hello, world!".getBytes());
            } catch (Exception ex) {
                System.getLogger("co.ivi.jus.stack.former")
                        .log(System.Logger.Level.WARNING,
                            algorithm + " does not work",
                             ex);
                continue;
            }

            availableAlgorithm = algorithm;
        }

        if (availableAlgorithm != null) {
            System.out.println(availableAlgorithm + " is available");
        } else {
            throw new RuntimeException("No available hash algorithm");
        }
    }
}
