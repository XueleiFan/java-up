/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.pattern.former;

public sealed interface Shape
        permits Shape.Circle, Shape.Square {

    record Circle(double radius) implements Shape {
        // blank
    }

    record Square(double side) implements Shape {
        // blank
    }
}
