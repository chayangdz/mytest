package reflecttest;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by chayang on 2016/12/31.
 */
public class ReflectTest {

    public static void main(String[] args) throws Exception {
        System.out.println(void.class);

        System.out.println(int.class == Integer.class);
        System.out.println(int.class == Integer.TYPE);

        System.out.println(int.class.isPrimitive());
        System.out.println(Integer.class.isPrimitive());

        System.out.println(int[].class);
        System.out.println(long[].class);
        System.out.println(boolean[].class);


        ReflectTest reflectTest = new ReflectTest();
        Method testMethod = ReflectTest.class.getMethod("test", String.class, int[].class);
        Class[] classes = (Class[]) testMethod.invoke(reflectTest, "abc", new int[] {1,2,3});
        System.out.println("result " + classes);


        Method method = ReflectTest.class.getMethod("test2", int[].class, String.class);
        method.invoke(reflectTest, new int[] {1,2,3}, "abc");

        Method method1 = ReflectTest.class.getMethod("test3", String.class, Integer[].class);
        method1.invoke(reflectTest, "abc", new Integer[] {1,2});

//        Method method2 = ReflectTest.class.getMethod("main", String[].class);
//        method2.invoke(null, new String[] {"1", "2"});

        Method method3 = ReflectTest.class.getMethod("test4", String[].class);
        method3.invoke(reflectTest, new String[] {"1", "2"});
    }

    public Class[] test(String name, int[] password) {
        System.out.println("test" + name + password);
        return new Class[]{String.class, Integer.class};
    }

    public void test2(int[] password, String name) {
        System.out.println("test2" + name + password);
    }

    public void test3(String name, Integer[] password) {
        System.out.println("test3");
    }

    public void test4(String[] args) {
        System.out.println("test4");
    }

    public void test5(String... args) {
        System.out.println("test5");
    }


    //public void test(String name, int... password) {
        //可变参数其实就是数组，反射的时候可以按照数组的反射就可以
   // }
}
