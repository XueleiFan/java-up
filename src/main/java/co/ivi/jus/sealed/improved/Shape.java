/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.sealed.improved;

    public abstract sealed class Shape {
//        permits Shape.Circle, Shape.Rectangle, Shape.Square {
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

    public static final class Rectangle extends Shape {
        public final double length;
        public final double width;

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
}
