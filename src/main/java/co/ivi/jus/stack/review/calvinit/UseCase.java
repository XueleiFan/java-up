/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.stack.review.calvinit;

public class UseCase {
    public static void main(String[] args) {
        Returned rt = Digest.of("SHA-128");
        switch (rt) {
            case Returned.ReturnValue rv -> {
                Digest d = (Digest) rv.returnValue();
                d.digest("Hello, world!".getBytes());
            }
            case Returned.ErrorCode ec -> {
                var errorCode = switch (ec) {
                    case NULL_ILLEGAL -> {
                        System.getLogger("co.ivi.jus.stack.union")
                                .log(System.Logger.Level.INFO, "Unlikely to happen");
                        yield ec.errorCode;
                    }
                    case NOT_SUPPORTED -> {
                        System.getLogger("co.ivi.jus.stack.union")
                                .log(System.Logger.Level.INFO, "SHA-218 is not supported");
                        yield ec.errorCode;
                    }
                };
                System.getLogger("co.ivi.jus.stack.union")
                        .log(System.Logger.Level.INFO, "errorCode is " + errorCode);
            }
        }
    }
}
