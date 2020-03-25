package jvmtest;

/**
 * Created by zhayang on 2019/7/22.
 */
public class MethodInvokeTest {


    /**
     * 重载的方法在编译过程中即可完成识别
     * 方法重载小知识：这个限制可以通过字节码工具绕开。
     * 也就是说，在编译完成之后，我们可以再向 class 文件中添加方法名和参数类型相同，而返回类型不同的方法。
     * 当这种包括多个方法名相同、参数类型相同，而返回类型不同的方法的类，出现在 Java 编译器的用户类路径上时，
     * 它是怎么确定需要调用哪个方法的呢？当前版本的 Java 编译器会直接选取第一个方法名以及参数类型匹配的方法。
     * 并且，它会根据所选取方法的返回类型来决定可不可以通过编译，以及需不需要进行值转换等。
     */

    public static void invoke(Object obj, Object... args) {
        System.out.println("invoke1");
    }

    public static void invoke(String s, Object obj, Object... args) {
        System.out.println("invoke2");
    }


    public static void main(String[] args) {
        invoke(null, 1);    // 调用第二个 invoke 方法
        invoke(null, 1, 2); // 调用第二个 invoke 方法
        invoke(null, new Object[]{1}); // 只有手动绕开可变长参数的语法糖，才能调用第一个 invoke 方法

    }
}
