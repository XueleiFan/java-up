/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.vector.simd;

import co.ivi.jus.flow.reactive.Returned;
import jdk.incubator.vector.FloatVector;

public class LinearEquation {
    private static final float[] a = new float[] {0.6F, 0.7F, 0.8F, 0.9F};
    private static final float[] x = new float[] {1.0F, 2.0F, 3.0F, 4.0F};

    private static final FloatVector va =
            FloatVector.fromArray(FloatVector.SPECIES_128, a, 0);
    private static final FloatVector vx =
            FloatVector.fromArray(FloatVector.SPECIES_128, x, 0);

    private static Returned<Float> sumInVector(FloatVector va, FloatVector vx) {
        if (va == null || vx == null || va.length() != vx.length()) {
            return new Returned.ErrorCode(-1);
        }

        // FloatVector vy = va.mul(vx);
        float[] y = va.mul(vx).toArray();

        float r = 0F;
        for (int i = 0; i < y.length; i++) {
            r += y[i];
        }

        return new Returned.ReturnValue<>(r);
    }

    public static void main(String[] args) {
        Returned<Float> rt = LinearEquation.sumInVector(va, vx);
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