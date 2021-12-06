/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.vector.former;

import co.ivi.jus.flow.reactive.Returned;

public class LinearEquation {
    private static final float[] a = new float[] {0.6F, 0.7F, 0.8F, 0.9F};
    private static final float[] x = new float[] {1.0F, 2.0F, 3.0F, 4.0F};

    private static Returned<Float> sumInScalar(float[] a, float[] x) {
        if (a == null || x == null || a.length != x.length) {
            return new Returned.ErrorCode(-1);
        }

        float[] y = new float[a.length];
        for (int i = 0; i < a.length; i++) {
            y[i] = a[i] * x[i];
        }

        float r = 0F;
        for (int i = 0; i < y.length; i++) {
            r += y[i];
        }

        return new Returned.ReturnValue<>(r);
    }

    public static void main(String[] args) {
        Returned<Float> rt = LinearEquation.sumInScalar(a, x);
        switch (rt) {
            case Returned.ReturnValue rv -> {
                // Get the returned value
                if (rv.returnValue() instanceof Float result) {
                    System.out.println("The summary is: " + result);
                } else {  // unlikely
                    System.out.println(
                            "Implementation error: LinearEquation.sumInScalar");
                }
            }
            case Returned.ErrorCode ec ->
                    System.out.println("Invalid input parameters");
        }
    }
}
