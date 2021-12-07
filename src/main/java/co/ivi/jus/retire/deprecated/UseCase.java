/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.retire.deprecated;

import java.security.NoSuchAlgorithmException;

public class UseCase {

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        try {
            Digest.of("SHA-256")
                  .digest("Hello, world!".getBytes());
        } catch (NoSuchAlgorithmException ex) {
            // ignore
        }
    }
}
