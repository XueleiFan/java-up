/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.error.union;

public class UseCase {
    public static void main(String[] args) {
        Returned<Digest> rt = Digest.of("SHA-256");
        switch (rt) {
            // case ReturnValue<Digest> rv -> {
            case Returned.ReturnValue rv -> {
                    // rv.returnValue().digest("Hello, world!".getBytes());
                    Digest d = (Digest) rv.returnValue();
                    d.digest("Hello, world!".getBytes());
                }
            case Returned.ErrorCode ec ->
                    System.out.println("Failed to get instance of SHA-256");
            // default ->
            //         System.out.println("Unlikely to happen");
        }
    }
}
