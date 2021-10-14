/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.pattern.extension;

public class UseCase {
    public static void main(String[] args) {
        System.out.println("Is null a square? " +
                UseCase.isSquare(null));
        System.out.println("Is a circle instance a square? " +
                UseCase.isSquare(new Shape.Circle(10)));
        System.out.println("Is a square instance a square? " +
                UseCase.isSquare(new Shape.Square(10)));
        System.out.println("Is a rectangle instance a square? " +
                UseCase.isSquare(new Shape.Rectangle(10, 10)));
    }

    public static boolean isSquare(Shape shape) {
        if (shape instanceof Shape.Rectangle rect) {
            return (rect.length() == rect.width());
        }

        return (shape instanceof Shape.Square);
    }
}
