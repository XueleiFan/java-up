/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.retire.removal;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public sealed abstract class Digest {
    private static final class Sha256 extends Digest {
        private static final Sha256 sha256 = new Sha256();

        private final MessageDigest md;

        private Sha256() {
            MessageDigest md;
            try {
                md = MessageDigest.getInstance("SHA-256");
            } catch (NoSuchAlgorithmException e) {
                md = null;
            }
            this.md = md;
        }

        @SuppressWarnings("removal")
        @Override
        public byte[] digest(byte[] message) {
            return md.digest(message);
        }
    }

    private static final class Sha512 extends Digest {
        private static final Sha512 sha512 = new Sha512();

        private final MessageDigest md;

        private Sha512() {
            MessageDigest md;
            try {
                md = MessageDigest.getInstance("SHA-512");
            } catch (NoSuchAlgorithmException e) {
                md = null;
            }
            this.md = md;
        }

        @SuppressWarnings("removal")
        @Override
        public byte[] digest(byte[] message) {
            return md.digest(message);
        }
    }

    public static Digest of(String algorithm) throws NoSuchAlgorithmException {
        return switch (algorithm) {
            case "SHA-256" -> {
                if (Sha256.sha256.md == null) {
                    throw new NoSuchAlgorithmException(
                            "Unsupported digest algorithm SHA-256");
                } else {
                    yield Sha256.sha256;
                }
            }
            case "SHA-512" -> {
                if (Sha512.sha512.md == null) {
                    throw new NoSuchAlgorithmException(
                            "Unsupported digest algorithm SHA-512");
                } else {
                    yield Sha512.sha512;
                }
            }
            case null, default -> throw new NoSuchAlgorithmException(
                    "Unsupported digest algorithm " + algorithm);
        };
    }

    @Deprecated(since = "1.4", forRemoval = true)
    public abstract byte[] digest(byte[] message);

    public void digest(byte[] message, byte[] digestValue) {
        byte[] digest = digest(message);
        System.arraycopy(digest, 0, digestValue, 0, digest.length);
    }
}
