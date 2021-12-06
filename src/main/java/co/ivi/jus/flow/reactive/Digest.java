/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.flow.reactive;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public sealed interface Digest {
    Returned.ErrorCode noSuchAlgorithmErrorCode = new Returned.ErrorCode(-1);

    final class Sha256 implements Digest {
        private static final Returned.ReturnValue<Digest> returnedSha256;

        private final MessageDigest md;

        static {
            Sha256 sha256 = new Sha256();
            returnedSha256 = sha256.md == null ?
                    null : new Returned.ReturnValue<>(sha256);
        }

        private Sha256() {
            MessageDigest md;
            try {
                md = MessageDigest.getInstance("SHA-256");
            } catch (NoSuchAlgorithmException e) {
                md = null;
            }
            this.md = md;
        }

        @Override
        public byte[] digest(byte[] message) {
            return md.digest(message);
        }
    }

    final class Sha512 implements Digest {
        private static final Returned.ReturnValue<Digest> returnedSha512;
        private final MessageDigest md;

        static {
            Sha512 sha512 = new Sha512();
            returnedSha512 = sha512.md == null ?
                    null : new Returned.ReturnValue<>(sha512);
        }

        private Sha512() {
            MessageDigest md;
            try {
                md = MessageDigest.getInstance("SHA-512");
            } catch (NoSuchAlgorithmException e) {
                md = null;
            }
            this.md = md;
        }

        @Override
        public byte[] digest(byte[] message) {
            return md.digest(message);
        }
    }

    static Returned<Digest> of(String algorithm) {
        return switch (algorithm) {
            case "SHA-256" -> (Sha256.returnedSha256 != null) ?
                    Sha256.returnedSha256 : noSuchAlgorithmErrorCode;
            case "SHA-512" -> Sha512.returnedSha512 != null ?
                    Sha512.returnedSha512 : noSuchAlgorithmErrorCode;
            case null, default -> noSuchAlgorithmErrorCode;
        };
    }

    byte[] digest(byte[] message);
}

