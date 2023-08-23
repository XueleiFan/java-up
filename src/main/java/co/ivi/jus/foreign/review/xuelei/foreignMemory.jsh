import jdk.incubator.foreign.*;

try (ResourceScope scope = ResourceScope.newConfinedScope()) {
    CLinker cLinker = CLinker.getInstance();
    MethodHandle cPrintf = cLinker.downcallHandle(
            CLinker.systemLookup().lookup("printf").get(),
            MethodType.methodType(int.class, MemoryAddress.class),
            FunctionDescriptor.of(CLinker.C_INT, CLinker.C_POINTER));

    MemorySegment helloWorld =
            CLinker.toCString("Hello, world!\n", scope);
    cPrintf.invoke(helloWorld.address());
}
