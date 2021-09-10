/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.instance.review.xuelei;

public sealed interface Shape
        permits Shape.Circle, Shape.Rectangle, Shape.Square {
    Shape.Rectangle rect = null;    // field variable

    record Circle(double radius) implements Shape {
        // blank
    }

    record Square(double side) implements Shape {
        // blank
    }

    record Rectangle(double length, double width) implements Shape {
        // blank
    }

    static void main(String[] args) {
        Shape shape = new Shape.Rectangle(10, 10);
        System.out.println("It should be ture that " + shape +
                " is a square: " + isSquare(shape));

        System.out.println();

        shape = new Shape.Circle(10);
        System.out.println("It cannot be ture that " + shape +
                " is a square: " + (!isSquare(shape)));
    }

    static boolean isSquare(Shape shape) {
        if (shape instanceof Rectangle rect) {
            // Field rect is shadowed, local rect is in scope
            System.out.println(
                    "This should be the local rect: " + rect.equals(shape));
            return (rect.length == rect.width);
        }

        // Field rect is in scope, local rect is not in scope here
        System.out.println(
                "This should be the field rect: " + (rect == null));
        return (shape instanceof Square);
    }
}
