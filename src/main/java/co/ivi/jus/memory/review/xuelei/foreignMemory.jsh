import jdk.incubator.foreign.*;

try (ResourceScope scope = ResourceScope.newConfinedScope()) {
    MemorySegment segment = MemorySegment.allocateNative(4, scope);
    for (int i = 0; i < 4; i++) {
        MemoryAccess.setByteAtOffset(segment, i, (byte)'A');
    }
}