/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.record.improved;

public record Square(double side) implements Shape {
    @Override
    public double area() {
        return side * side;
    }
}
