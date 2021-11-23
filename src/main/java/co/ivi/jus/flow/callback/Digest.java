/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.flow.callback;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.function.Consumer;

public sealed abstract class Digest {
    private static final Sha256 sha256 = new Sha256();
    private static final Sha512 sha512 = new Sha512();

    private static final class Sha256 extends Digest {
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

        @Override
        public void digest(byte[] message,
               Consumer<byte[]> onSuccess, Consumer<Integer> onFailure) {
            onSuccess.accept(md.digest(message));
        }
    }

    private static final class Sha512 extends Digest {
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

        @Override
        public void digest(byte[] message,
               Consumer<byte[]> onSuccess, Consumer<Integer> onFailure) {
            onSuccess.accept(md.digest(message));
        }
    }

    public static void of(String algorithm,
        Consumer<Digest> onSuccess, Consumer<Integer> onFailure) {
        switch (algorithm) {
            case "SHA-256" -> {
                if (sha256.md != null) {
                    onSuccess.accept(sha256);
                } else {
                    onFailure.accept(-1);
                }
            }
            case "SHA-512" -> {
                if (sha512.md != null) {
                    onSuccess.accept(sha512);
                } else {
                    onFailure.accept(-1);
                }
            }
            case null, default ->
                    onFailure.accept(-1);
        };
    }

    public abstract void digest(byte[] message,
            Consumer<byte[]> onSuccess, Consumer<Integer> onFailure);
}
