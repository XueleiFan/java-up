import jdk.incubator.vector.*;
float[] a = new float[] {0.6F, 0.7F, 0.8F, 0.9F};
float[] x = new float[] {1.0F, 2.0F, 3.0F, 4.0F};
FloatVector va = FloatVector.fromArray(FloatVector.SPECIES_128, a, 0);
FloatVector vx = FloatVector.fromArray(FloatVector.SPECIES_128, x, 0);
va.mul(vx);
