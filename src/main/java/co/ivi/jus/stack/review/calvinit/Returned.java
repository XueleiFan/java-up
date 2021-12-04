/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.stack.review.calvinit;

public sealed interface Returned {
    record ReturnValue<T>(T returnValue) implements Returned {
    }

    enum ErrorCode implements Returned {

        NULL_ILLEGAL(-1), NOT_SUPPORTED(-2);

        public final int errorCode;

        ErrorCode(int errorCode) {
            this.errorCode = errorCode;
        }
    }
}
