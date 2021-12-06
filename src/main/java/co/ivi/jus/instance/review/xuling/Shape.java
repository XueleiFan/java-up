/*
 * Copyright (c) 2021, Ling Xu. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.instance.review.xuling;

/**
 * pattern match work
 *
 * @author jack
 * @since 2021/11/24
 **/
public sealed interface Shape
        permits Shape.Circle, Shape.Rectangle, Shape.Square {
    co.ivi.jus.instance.review.xuelei.Shape.Rectangle rect = null;    // field variable

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
        System.out.println("It can't be ture that " + shape +
                " is a circle: " + !isCircle(shape));

        System.out.println();

        shape = new Shape.Circle(10);
        System.out.println("It cannot be ture that " + shape +
                " is a square: " + (!isSquare(shape)));
        System.out.println("It should be ture that " + shape +
                " is a circle: " + isCircle(shape));
    }

    static boolean isSquare(Shape shape) {
        if (!(shape instanceof Shape.Rectangle rect)) {
            // Field rect is in scope, local rect is not in scope here
            System.out.println(
                    "This should be the field rect: " + (rect == null));
        } else {
            // Field rect is shadowed, local rect is in scope
            System.out.println(
                    "This should be the local rect: " + rect.equals(shape));
            return (rect.length == rect.width);
        }

        // Field rect is in scope, local rect is not in scope here, this case is not mentioned.
        System.out.println(
                "This should be the field rect: " + (rect == null));
        return (shape instanceof Shape.Square);
    }

    static boolean isCircle(Shape shape) {
        if (!(shape instanceof Shape.Rectangle rect)) {
            // Field rect is in scope, local rect is not in scope here
            System.out.println(
                    "This should be the field rect: " + (rect == null));
            return (shape instanceof Shape.Circle);
        }

        // Field rect is shadowed, local rect is in scope
        System.out.println(
                "This should be the field rect: " + (rect.equals(shape)));
        return false;
    }
}