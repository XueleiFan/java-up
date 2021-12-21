/*
 * Copyright (c) 2021, songor. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.nullp.review.songor;

public final class FullName {
    private final String firstName;
    private final String middleName;
    private final String lastName;

    public FullName(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public Returned firstName() {
        if (firstName == null) {
            return Returned.ErrorCode.UNDEFINED;
        }
        return new Returned.ReturnValue<>(firstName);
    }

    public Returned middleName() {
        if (middleName == null) {
            return Returned.ErrorCode.UNDEFINED;
        }
        return new Returned.ReturnValue<>(middleName);
    }

    public Returned lastName() {
        if (lastName == null) {
            return Returned.ErrorCode.UNDEFINED;
        }
        return new Returned.ReturnValue<>(lastName);
    }
}
