/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.error.coded;

public class UseCase {
    public static void main(String[] args) {
        Coded<Digest> coded = Digest.of("SHA-256");
        if (coded.errorCode() != 0) {
            // ignore
        } else {
            coded.returned().digest("Hello, world!".getBytes());
        }
    }
}
