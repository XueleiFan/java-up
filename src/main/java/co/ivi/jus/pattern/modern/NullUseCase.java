/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.pattern.modern;

import co.ivi.jus.pattern.former.Shape;

public class NullUseCase {
    public static void main(String[] args) {
        System.out.println("Is null a square? " +
                NullUseCase.isSquare(null));
    }

    public static boolean isSquare(Shape shape) {
        return switch (shape) {
            case Shape.Circle c -> false;
            case Shape.Square s -> true;
        };
    }
}
