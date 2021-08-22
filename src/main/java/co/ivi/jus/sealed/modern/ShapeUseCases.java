/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.sealed.modern;

public class ShapeUseCases {
    public static void main(String[] args) {
        System.out.println("Is it a circle? " +
                ShapeUseCases.isSquare(null));
        System.out.println("Is it a square? " +
                ShapeUseCases.isSquare(null));
        System.out.println("Is it a square? " +
                ShapeUseCases.isSquare(new Square("circle", 3)));
    }

    public static boolean isCircle(Shape shape) {
       return (shape instanceof Circle);
    }

    public static boolean isSquare(Shape shape) {
        return switch (shape) {
            case null -> false;
            case Square s -> true;
            case Rectangle r -> r.length == r.width;
            default -> false;
        };
    }
}
