/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.foreign.jni;

public class HelloWorld {
    static {
        System.loadLibrary("helloWorld");
    }

    public static void main(String[] args) {
        new HelloWorld().sayHello();
    }

    private native void sayHello();
}
