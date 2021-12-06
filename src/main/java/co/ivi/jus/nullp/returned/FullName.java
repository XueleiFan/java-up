/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.nullp.returned;

import java.util.Objects;

public final class FullName {
    private final String firstName;
    private final String middleName;
    private final String lastName;

    public FullName(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public Returned<String> firstName() {
        if (firstName == null) {
            return new Returned.Undefined();
        }

        return new Returned.ReturnValue<>(firstName);
    }

    public Returned<String> middleName() {
        if (middleName == null) {
            return Returned.UNDEFINED;
        }

        return new Returned.ReturnValue<>(middleName);
    }

    public Returned<String> lastName() {
        if (lastName == null) {
            return new Returned.Undefined();
        }

        return new Returned.ReturnValue<>(lastName);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof FullName that)) {
            return false;
        }

        return Objects.equals(this.firstName, that.firstName) &&
                Objects.equals(this.middleName, that.middleName) &&
                Objects.equals(this.lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, middleName, lastName);
    }

    @Override
    public String toString() {
        return "FullName[" +
                "firstName=" + firstName + ", " +
                "middleName=" + middleName + ", " +
                "lastName=" + lastName + ']';
    }
}
