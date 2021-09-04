/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.sealed;

import co.ivi.jus.sealed.former.Circle;
import co.ivi.jus.sealed.former.Rectangle;
import co.ivi.jus.sealed.former.Shape;
import co.ivi.jus.sealed.former.Square;

public class FormerUseCases {
    public static boolean isCircle(Shape shape) {
       return (shape instanceof Circle);
    }

    public static boolean isSquare(Shape shape) {
        if (shape instanceof Rectangle rect) {
            return (rect.length == rect.width);
        }

        return (shape instanceof Square);
    }
}
