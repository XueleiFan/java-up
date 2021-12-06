/*
 * Copyright (c) 2021, songor. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.error.review.songor;

import co.ivi.jus.error.union.Digest;
import co.ivi.jus.error.union.Returned;

public class UseCase {
    public static void main(String[] args) {
        Returned<Digest> rt = Digest.of("SHA-256");
        if (rt instanceof Returned.ReturnValue rv && rv.returnValue() instanceof Digest d) {
            d.digest("Hello, world!".getBytes());
        } else if (rt instanceof Returned.ErrorCode ec) {
            System.out.println("Failed to get instance of SHA-256");
        } else {
            // 不能使用 switch 模式匹配（穷举出所有的情景）而带来的不便之处
            throw new UnsupportedOperationException("Invalid Returned instance");
        }
    }
}
