/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.error.former;

import java.security.NoSuchAlgorithmException;

public class NoCatchCase {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Digest md = Digest.of("SHA-128");
        md.digest("Hello, world!".getBytes());
    }
}
