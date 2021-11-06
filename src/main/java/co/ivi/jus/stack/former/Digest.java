/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.stack.former;

import java.security.NoSuchAlgorithmException;

public sealed abstract class Digest {
    private static final class SHA256 extends Digest {
        @Override
        public byte[] digest(byte[] message) {
            // snipped
            return new byte[0];
        }
    }

    private static final class SHA512 extends Digest {
        @Override
        public byte[] digest(byte[] message) {
            // snipped
            return new byte[0];
        }
    }

    public static Digest of(String algorithm) throws NoSuchAlgorithmException {
        return switch (algorithm) {
            case "SHA-256" -> new SHA256();
            case "SHA-512" -> new SHA512();
            case null, default -> throw new NoSuchAlgorithmException(
                    "Unsupported digest algorithm " + algorithm);
        };
    }

    public abstract byte[] digest(byte[] message);
}
