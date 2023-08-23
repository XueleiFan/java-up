/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.nullp.optional;

import java.util.Objects;
import java.util.Optional;

public final class FullName {
    private final String firstName;
    private final String middleName;
    private final String lastName;

    public FullName(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public Optional<String> firstName() {
        return Optional.ofNullable(firstName);
    }

    public Optional<String> middleName() {
        return Optional.ofNullable(middleName);
    }

    public Optional<String> lastName() {
        return Optional.ofNullable(lastName);
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
