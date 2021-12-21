/*
 * Copyright (c) 2021, songor. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.stack.review.songor;

public class UseCase {
    public static void main(String[] args) {
        Returned rt = Digest.of("SHA-128");
        switch (rt) {
            case Returned.ReturnValue rv -> {
                Digest d = (Digest) rv.returnValue();
                d.digest("Hello, world!".getBytes());
            }
            case Returned.ErrorCode ec -> {
                switch (ec) {
                    case NO_SPECIFIED_ALGORITHM -> System.getLogger("co.ivi.jus.stack.review.songor")
                            .log(System.Logger.Level.INFO,
                                    "Unlikely to happen");
                    case UNKNOWN_SPECIFIED_ALGORITHM -> System.getLogger("co.ivi.jus.stack.review.songor")
                            .log(System.Logger.Level.INFO,
                                    "SHA-218 is not supported");
                }
            }
        }
    }
}
