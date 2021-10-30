/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.error.coded;

public sealed abstract class Digest {
    private static final class SHA256 extends Digest {
        @Override
        byte[] digest(byte[] message) {
            // snipped
            return new byte[0];
        }
    }

    private static final class SHA512 extends Digest {
        @Override
        byte[] digest(byte[] message) {
            // snipped
            return new byte[0];
        }
    }

    public static Coded<Digest> of(String algorithm) {
        return switch (algorithm) {
            case "SHA-256" -> new Coded(new SHA256(), 0);
            case "SHA-512" -> new Coded(new SHA512(), 0);
            case null, default -> new Coded(null, -1);
        };
    }

    abstract byte[] digest(byte[] message);
}
