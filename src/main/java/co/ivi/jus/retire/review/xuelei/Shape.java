/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.retire.review.xuelei;

public abstract sealed class Shape {
    public final String id;

    public Shape(String id) {
        this.id = id;
    }

    public abstract double area();

    public static final class Circle extends Shape {
        public final double radius;

        public Circle(String id, double radius) {
            super(id);
            this.radius = radius;
        }

        @Override
        public double area() {
            return Math.PI * radius * radius;
        }
    }

    public static final class Square extends Shape {
        public final double side;

        public Square(String id, double side) {
            super(id);
            this.side = side;
        }

        @Override
        public double area() {
            return side * side;
        }
    }

    // Here is your code for Rectangle.

    // Here is the test for circle.
    public static boolean isCircle(Shape shape) {
        // Here goes your update.
        return (shape instanceof Circle);
    }

    // Here is the code to run your test.
    public static void main(String[] args) {
        // Here is your code.
    }
}
