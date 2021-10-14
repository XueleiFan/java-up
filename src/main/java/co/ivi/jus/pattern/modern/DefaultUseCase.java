/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.pattern.modern;

import co.ivi.jus.pattern.former.Shape;

public class DefaultUseCase {
    public static void main(String[] args) {
        System.out.println("Is null a square? " +
                DefaultUseCase.isSquare(null));
        System.out.println("Is a circle instance a square? " +
                DefaultUseCase.isSquare(new Shape.Circle(10)));
    }

    public static boolean isSquare(Shape shape) {
        return switch (shape) {
            case Shape.Square s -> true;
            case null, default -> false;
        };
    }
}
