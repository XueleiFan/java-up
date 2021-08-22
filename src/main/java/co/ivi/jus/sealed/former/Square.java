/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.sealed.former;

public class Square extends Shape {
    final double side;

    public Square(String id, double side) {
        super(id);
        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }
}
