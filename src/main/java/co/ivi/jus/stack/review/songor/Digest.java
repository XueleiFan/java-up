/*
 * Copyright (c) 2021, songor. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.stack.review.songor;

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
            case "SHA-256" -> new Returned.ReturnValue<Digest>(new SHA256());
            case "SHA-512" -> new Returned.ReturnValue<Digest>(new SHA512());
            case null -> {
                System.getLogger("co.ivi.jus.stack.review.songor")
                        .log(System.Logger.Level.WARNING,
                                "No algorithm is specified",
                                new Throwable("the calling stack"));
                yield Returned.ErrorCode.NO_SPECIFIED_ALGORITHM;
            }
            default -> {
                System.getLogger("co.ivi.jus.stack.review.songor")
                        .log(System.Logger.Level.INFO,
                                "Unknown algorithm is specified " + algorithm,
                                new Throwable("the calling stack"));
                yield Returned.ErrorCode.UNKNOWN_SPECIFIED_ALGORITHM;
            }
        };
    }

    public abstract byte[] digest(byte[] message);
}
