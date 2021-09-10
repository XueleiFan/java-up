/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.instance.modern;

import co.ivi.jus.instance.modern.Shape.Circle;
import co.ivi.jus.instance.modern.Shape.Rectangle;

public final class Shadowed {
    private static final Rectangle rect = null;

    public static void main(String[] args) {
        Shape shape = new Rectangle(10, 10);
        System.out.println("It should be ture that " + shape +
                " is a square: " + isSquare(shape));

        System.out.println();

        shape = new Circle(10);
        System.out.println("It cannot be ture that " + shape +
                " is a square: " + isSquare(shape));
    }

    public static boolean isSquare(Shape shape) {
        if (!(shape instanceof Rectangle rect)) {
            // Field rect is in scope, local rect is not in scope here
            System.out.println("This should be the field rect: " + rect);
            return shape instanceof Shape.Square;
        }

        // Field rect is shadowed, local rect is in scope
        System.out.println("This should be the local rect: " + rect);
        return rect.length() == rect.width();
    }
}
