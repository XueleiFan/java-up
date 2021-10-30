/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.error.union;

public sealed interface Returned<T> {
    record ReturnValue<T>(T returnValue) implements Returned {
    }

    record ErrorCode(Integer errorCode) implements Returned {
    }

    /*
    public static final class ReturnValue<T> implements Returned {
        public final T returnValue;

        public ReturnValue(T returnValue) {
            this.returnValue = returnValue;
        }
    }

    public static final class ErrorCode implements Returned {
        public final Integer errorCode;

        public ErrorCode(int errorCode) {
            this.errorCode = errorCode;
        }
    }
     */
}
