/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.pattern.extension;

public sealed interface Shape
        permits Shape.Circle, Shape.Rectangle, Shape.Square {

    /**
     * @since 1.0
     */
    record Circle(double radius) implements Shape {
        // blank
    }

    /**
     * @since 1.0
     */
    record Square(double side) implements Shape {
        // blank
    }

    /**
     * @since 2.0
     */
    record Rectangle(double length, double width) implements Shape {
        // blank
    }
}
