/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.instance.modern;

public sealed interface Shape
        permits Shape.Circle, Shape.Rectangle, Shape.Square {

    record Circle(double radius) implements Shape {
        // blank
    }

    record Square(double side) implements Shape {
        // blank
    }

    record Rectangle(double length, double width) implements Shape {
        // blank
    }

    static boolean isSquare(Shape shape) {
        if (shape instanceof Rectangle rect) {
            return (rect.length == rect.width);
        }

        return (shape instanceof Square);
    }
}
