/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.use;

import co.ivi.jus.crypto.Digest;
import co.ivi.jus.crypto.Returned;

public class UseCase {
    public static void main(String[] args) {
        Returned<Digest> rt = Digest.of("SHA-256");
        switch (rt) {
            case Returned.ReturnValue rv -> {
                Digest d = (Digest) rv.returnValue();
                d.digest("Hello, world!".getBytes());
            }
            case Returned.ErrorCode ec ->
                    System.getLogger("co.ivi.jus.stack.union")
                            .log(System.Logger.Level.INFO,
                                    "Failed to get instance of SHA-256");
        }
    }
}