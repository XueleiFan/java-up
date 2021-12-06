/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.nullp.optional;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

public class UseCase {
    public static void main(String[] args) {
        FullName jack = new FullName("Jack", "", "Brown");
        FullName rose = new FullName("Rose", null, "Brown");
        FullName nova = new FullName("Nova", "Diane", "Brown");
        System.out.println(
                "Is Jack's middle name Diane? " +
                        hasMiddleName(jack, "Diane"));
        System.out.println(
                "Is Rose's middle name Diane? " +
                        hasMiddleName(rose, "Diane"));
        System.out.println(
                "Is Nova's middle name Diane? " +
                        hasMiddleName(nova, "Diane"));
    }

    private static boolean hasMiddleName(FullName fullName, String middleName) {
        return fullName.middleName().get().equals(middleName);
    }

    private static boolean hasMiddleNameImplB(FullName fullName, String middleName) {
        return fullName.middleName().equals(Optional.ofNullable(middleName));
    }

    private static boolean hasMiddleNameImplC(FullName fullName, String middleName) {
        return fullName.middleName().isPresent() ?
                   fullName.middleName().get().equals(middleName) :
                   middleName == null;
    }

    private static boolean hasMiddleNameImplD(FullName fullName, String middleName) {
        if (fullName.middleName().isPresent()) {
            return fullName.middleName().get().equals(middleName);
        }

        return middleName == null;
    }

    private static boolean hasMiddleNameImplE(FullName fullName, String middleName) {
        AtomicBoolean isMatched = new AtomicBoolean(false);
        fullName.middleName().ifPresentOrElse(
                v -> isMatched.set(v.equals(middleName)),
                () -> isMatched.set(middleName == null)
            );

        return isMatched.get();
    }
}
