/*
 * Copyright (c) 2021, Ling Xu. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.pattern.review.xuling;

import co.ivi.jus.pattern.extension.Shape;

/**
 * pattern match homework
 *
 * @author jack
 * @since 2021/11/30
 **/
public class UseCase {

    public static void main(String[] args) {
        System.out.println("Is null a square? " + isSquare(null));
        System.out.println("Is a circle instance a square? " + isSquare(new Shape.Circle(10)));
        System.out.println("Is a square instance a square? " + isSquare(new Shape.Square(10)));
        System.out.println("Is a rectangle(10, 10) instance a square? " + isSquare(new Shape.Rectangle(10, 10)));
        System.out.println("Is a rectangle(10, 5) instance a square? " + isSquare(new Shape.Rectangle(10, 5)));
    }

    public static boolean isSquare(Shape shape) {
        return switch (shape) {
            case null, Shape.Circle c -> false;
            case Shape.Square s -> true;
            case Shape.Rectangle r -> r.length() == r.width();
        };
    }
}
