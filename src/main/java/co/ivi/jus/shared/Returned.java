/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.shared;

public sealed interface Returned<T> {
    record ReturnValue<T>(T returnValue) implements Returned {
    }

    record ErrorCode(Integer errorCode) implements Returned {
    }
}
