/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.jshell.former;

public class StringLiterals {
    public static void main(String[] args) {
        String s1 = "Hello, World!";
        String s2 = "Hello, World!";

        System.out.println("Does s1 equal to s2? " + s1.equals(s2));
        System.out.println("Does s1 refer to s2? " + (s1 == s2));
    }
}
