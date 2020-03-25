package jvmtest;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * Created by zhayang on 2019/8/7.
 */
public class MethodHandleTest {

    public static void test(Object object) {
        System.out.println("lalala");
    }

    public static void main(String[] args) throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType methodType = MethodType.methodType(void.class, Object.class);
        MethodHandle methodHandle = lookup.findStatic(MethodHandleTest.class, "test", methodType);
        methodHandle.invokeExact(new Object());
    }
}
