/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.flow.former;

import java.security.NoSuchAlgorithmException;

public class UseCase {
    public static void main(String[] args) {
        try {
            Digest.of("SHA-256")
                  .digest("Hello, world!".getBytes());
            System.out.println("SHA-256 is available");
        } catch (NoSuchAlgorithmException ex) {
            // ignore, continue to use the next algorithm.
            System.out.println("Unsupported algorithm: SHA-256");
        }
    }
}
