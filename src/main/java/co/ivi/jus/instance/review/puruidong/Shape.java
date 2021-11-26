/*
 * Copyright (c) 2021, Ruidong Pu. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

public sealed interface Shape
        permits Shape.Circle, Shape.Rectangle, Shape.Square {
    // field variable
    Shape.Rectangle rect = null;    

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
        System.out.println(isSquareA(shape));
        System.out.println(isSquareF(shape));

        System.out.println();

        shape = new Shape.Circle(10);
        System.out.println("It cannot be ture that " + shape +
                " is a square: " + (!isSquare(shape)));
        System.out.println(!isSquareA(shape));
        System.out.println(!isSquareF(shape));
    }

    static boolean isSquareA(Shape shape) {
        if (shape instanceof Rectangle rect) {
            return rect.length() == rect.width();
        }
        return shape instanceof Square;
    }

    static boolean isSquareF(Shape shape) {
        if (shape instanceof Rectangle rect) {
            return rect.length() == rect.width();
        }
        return shape instanceof Shape.Square;
    }

    // nice.
    static boolean isSquare(Shape shape) {
        return shape instanceof Square || shape instanceof Rectangle rect && rect.length == rect.width;
    }
}
