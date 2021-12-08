/*
 * Copyright (c) 2021, songor. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.stack.review.songor;

public sealed interface Returned {
    record ReturnValue<T>(T returnValue) implements Returned {
    }

    enum ErrorCode implements Returned {
        NO_SPECIFIED_ALGORITHM, UNKNOWN_SPECIFIED_ALGORITHM
    }
}
