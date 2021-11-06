/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.stack.callback;

import java.util.function.Consumer;

public sealed abstract class Digest {
    private static final class SHA256 extends Digest {
        @Override
        public void digest(byte[] message,
               Consumer<byte[]> onSuccess, Consumer<Integer> onFailure) {
            // snipped
            return;
        }
    }

    private static final class SHA512 extends Digest {
        @Override
        public void digest(byte[] message,
                Consumer<byte[]> onSuccess, Consumer<Integer> onFailure) {
            // snipped
            onFailure.accept(-1);
        }
    }

    public static void of(String algorithm,
        Consumer<Digest> onSuccess, Consumer<Integer> onFailure) {
        switch (algorithm) {
            case "SHA-256" ->
                    onSuccess.accept(new SHA256());
            case "SHA-512" ->
                    onSuccess.accept(new SHA512());
            case null, default ->
                    onFailure.accept(-1);
        };
    }

    public abstract void digest(byte[] message,
            Consumer<byte[]> onSuccess, Consumer<Integer> onFailure);
}
