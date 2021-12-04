/*
 * Copyright (c) 2021, songor. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.sealed.review.songor;

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

    public static boolean isCircle(Shape shape) {
        return (shape instanceof Circle);
    }

    public static boolean isSquare(Shape shape) {
        return shape instanceof Square || shape instanceof Rectangle rectangle && rectangle.length == rectangle.width;
    }

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle("1", 1.0D, 1.0D);
        System.out.println("rectangle is special square (same length and width)? " + Shape.isSquare(rectangle));
        System.out.println("rectangle is circle? " + Shape.isCircle(rectangle));

        Square square = new Square("2", 1.0D);
        System.out.println("square is square? " + Shape.isSquare(square));
        System.out.println("square is circle? " + Shape.isCircle(square));

        System.out.println("circle is circle? " + Shape.isCircle(new Circle("3", 1.0D)));
    }
}
