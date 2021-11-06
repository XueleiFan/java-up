/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.stack.review.xuelei;

public class UseCase {
    public static void main(String[] args) {
        Returned<Digest> rt = Digest.of("SHA-128");
        switch (rt) {
            case Returned.ReturnValue rv -> {
                    Digest d = (Digest) rv.returnValue();
                    d.digest("Hello, world!".getBytes());
                }
            case Returned.ErrorCode ec -> {
                if (ec.errorCode() == -1) {
                    System.getLogger("co.ivi.jus.stack.union")
                            .log(System.Logger.Level.INFO,
                                    "Unlikedly to happen");
                } else {
                    System.getLogger("co.ivi.jus.stack.union")
                            .log(System.Logger.Level.INFO,
                                    "SHA-218 is not supported");
                }
            }
        }
    }
}
