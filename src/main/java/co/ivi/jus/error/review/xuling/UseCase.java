/*
 * Copyright (c) 2021, Ling Xu. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.error.review.xuling;

import co.ivi.jus.error.union.Digest;
import co.ivi.jus.error.union.Returned;

/**
 * homework for error
 *
 * @author jack
 * @since 2021/12/2
 **/
public class UseCase {
    public static void main(String[] args) {
        Returned<Digest> rt = Digest.of("SHA-256");
        if(rt instanceof Returned.ReturnValue rv) {
            Digest d = (Digest) rv.returnValue();
            d.digest("Hello, world!".getBytes());
        } else {
            System.out.println("Failed to get instance of SHA-256");
        }
    }
}
