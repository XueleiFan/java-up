/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.sealed.propagate;

public abstract sealed class Shape {
//        permits Shape.Circle, Shape.Rectangle, Shape.Square {
    final String id;

    public Shape(String id) {
        this.id = id;
    }

    public abstract double area();

    public static non-sealed class Circle extends Shape {
        final double radius;

        public Circle(String id, double radius) {
            super(id);
            this.radius = radius;
        }

        @Override
        public double area() {
            return Math.PI * radius * radius;
        }
    }

    public static final class Rectangle extends Shape {
        final double length;
        final double width;

        public Rectangle(String id, double length, double width) {
            super(id);
            this.length = length;
            this.width = width;
        }

        @Override
        public double area() {
            return length * width;
        }
    }

    public static sealed class Square extends Shape {
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

    public static final class ColoredSquare extends Square {
        final int rgb;

        public ColoredSquare(String id, double side, int rgb) {
            super(id, side);
            this.rgb = rgb;
        }
    }

    public static class ColoredCircle extends Circle {
        final int rgb;

        public ColoredCircle(String id, double radius, int rgb) {
            super(id, radius);
            this.rgb = rgb;
        }
    }
}
