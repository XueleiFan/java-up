/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.instance.modern;

import co.ivi.jus.instance.modern.Shape.Square;
import co.ivi.jus.instance.modern.Shape.Rectangle;

public final class Scope {
    public static boolean isSquareImplA(Shape shape) {
        if (shape instanceof Rectangle rect) {
            // rect is in scope
            return rect.length() == rect.width();
        }

        // rect is not in scope here
        return shape instanceof Square;
    }

    public static boolean isSquareImplB(Shape shape) {
        if (!(shape instanceof Rectangle rect)) {
            // rect is not in scope here
            return shape instanceof Square;
        }

        // rect is in scope
        return rect.length() == rect.width();
    }

    public static boolean isSquareImplC(Shape shape) {
        return shape instanceof Square ||  // rect is not in scope here
              (shape instanceof Rectangle rect &&
               rect.length() == rect.width());   // rect is in scope here
    }

    /*
   // Comment this method out as it is not compilable.
    public static boolean isSquareImplD(Shape shape) {
        return shape instanceof Square ||  // rect is not in scope here
              (shape instanceof Rectangle rect ||
               rect.length() == rect.width());   // rect is not in scope here
    }

    // Comment this method out as it is not compilable.
    public static boolean isSquareImplE(Shape shape) {
        return shape instanceof Square |  // rect is not in scope here
              (shape instanceof Rectangle rect &
               rect.length() == rect.width());   // rect is in scope here
    }
     */
}
