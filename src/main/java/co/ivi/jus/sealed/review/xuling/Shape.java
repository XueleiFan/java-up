/*
 * Copyright (c) 2021, Ling Xu. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.sealed.review.xuling;

/**
 * sealed shape demo
 *
 * @author jack
 * @since 2021/11/22
 **/
public abstract sealed class Shape permits Shape.Circle, Shape.Square, Shape.Rectangle {
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

    // Here is the test for circle.
    public static boolean isCircle(Shape shape) {
        // Here goes your update.
        return (shape instanceof Circle);
    }

    // Here is the test for square.
    public static boolean isSquare(Shape shape) {
        if (shape instanceof Rectangle rect) {
            return (rect.length == rect.width);
        }
        return (shape instanceof Square);
    }

    // Here is the code to run your test.
    public static void main(String[] args) {
        // Here is your code.
        Circle circle = new Circle("1", 2.0);
        Square square = new Square("2", 2.0);
        Rectangle rectangle = new Rectangle("3", 1.0, 2.0);
        Rectangle square2 = new Rectangle("3", 2.0, 2.0);
        System.out.println("circle is square: " + Shape.isSquare(circle));
        System.out.println("square is square: " + Shape.isSquare(square));
        System.out.println("rectangle is square: " + Shape.isSquare(rectangle));
        System.out.println("square2 is square: " + Shape.isSquare(square2));
    }
}
