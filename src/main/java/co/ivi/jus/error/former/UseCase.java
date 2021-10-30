/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.error.former;

import java.security.NoSuchAlgorithmException;

public class UseCase {
    public static void main(String[] args) {
        try {
            Digest md = Digest.of("SHA-256");
            md.digest("Hello, world!".getBytes());
        } catch (NoSuchAlgorithmException nsae) {
            // ignore
        }
    }
}
