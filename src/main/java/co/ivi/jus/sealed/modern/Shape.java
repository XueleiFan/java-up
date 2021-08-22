/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.sealed.modern;

public abstract sealed class Shape permits Circle, Rectangle, Square {
    final String id;

    public Shape(String id) {
        this.id = id;
    }

    public abstract double area();
}
