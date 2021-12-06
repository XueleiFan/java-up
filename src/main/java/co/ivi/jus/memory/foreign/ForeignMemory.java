/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.memory.foreign;

import jdk.incubator.foreign.*;

public class ForeignMemory {
    public static void main(String[] args) {
        try (ResourceScope scope = ResourceScope.newConfinedScope()) {
            MemorySegment segment = MemorySegment.allocateNative(4, scope);
            for (int i = 0; i < 4; i++) {
                MemoryAccess.setByteAtOffset(segment, i, (byte)'A');
            }
        }
    }
}