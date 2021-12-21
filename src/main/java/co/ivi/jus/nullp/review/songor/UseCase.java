/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.nullp.review.songor;

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
        return switch (fullName.middleName()) {
            case Returned.ErrorCode ec -> switch (ec) {
                case UNDEFINED -> false;
            };
            case Returned.ReturnValue rv -> {
                String returnedMiddleName = (String) rv.returnValue();
                yield returnedMiddleName.equals(middleName);
            }
        };
    }
}
