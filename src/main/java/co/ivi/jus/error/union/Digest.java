/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.error.union;

import co.ivi.jus.error.union.Returned.ReturnValue;
import co.ivi.jus.error.union.Returned.ErrorCode;

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

    public static Returned<Digest> of(String algorithm) {
        return switch (algorithm) {
            case "SHA-256" -> new ReturnValue(new SHA256());
            case "SHA-512" -> new ReturnValue(new SHA512());
            case null, default -> new ErrorCode(-1);
        };
    }

    public abstract byte[] digest(byte[] message);
}
