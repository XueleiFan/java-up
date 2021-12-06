/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.flow.former;

import java.security.NoSuchAlgorithmException;

public class SimpleUseCase {
    public static void main(String[] args) {
        try {
            Digest messageDigest = Digest.of("SHA-256");
            byte[] digestValue = messageDigest.digest("Hello, world!".getBytes());
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("Unsupported algorithm: SHA-256");
        }
    }
}
