/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.stack.review.calvinit;

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

    public static Returned of(String algorithm) {
        return switch (algorithm) {
            case "SHA-256" -> new Returned.ReturnValue<>(new SHA256());
            case "SHA-512" -> new Returned.ReturnValue<>(new SHA512());
            case null -> {
                System.getLogger("co.ivi.jus.stack.union")
                        .log(System.Logger.Level.WARNING,
                            "No algorithm is specified",
                            new Throwable("the calling stack"));
                yield Returned.ErrorCode.NULL_ILLEGAL;
            }
            default -> {
                System.getLogger("co.ivi.jus.stack.union")
                        .log(System.Logger.Level.INFO,
                        "Unknown algorithm is specified " + algorithm,
                                new Throwable("the calling stack"));
                yield Returned.ErrorCode.NOT_SUPPORTED;
            }
        };
    }

    public abstract byte[] digest(byte[] message);
}
