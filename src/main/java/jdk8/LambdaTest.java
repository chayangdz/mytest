package jdk8;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author zhayang
 * Created on 2020-04-04
 */
public class LambdaTest {


    /**
     * lambda学习
     * 其实语法很简单，就是() -> {} 这种格式的
     * ()里面就是入参，{}就是方法体
     * lambda表达式适合匿名类这种场景，本来需要new一个接口的，现在直接写这个表达式就行了
     * lambda只适用于接口中只有一个需要重写的方法的场景
     * <p>
     * 除了上面的场景，还有另一种lambda表达式的场景。
     * 有时候接口中的方法已经在其他地方被实现过了，那可以利用::来指向这个方法
     * 如果是静态方法，就是类名::方法，如果是普通方法，就是实例对象::方法
     */

    public static void main(String[] args) {

        MyInterface myInterface = (int a, int b) -> {
            System.out.println("hahaha");
            return 0;
        };
        myInterface.test(1, 2);

        // 表达式也可以简化，比如不写参数的类型，全都省略
        // 如果只有一个参数，可以省略参数的()
        // 如果方法体里只有一行语句，可以省略方法体的{}，甚至进一步可以省略return关键字
        MyInterface myInterface1 = (a, b) -> 0;
        myInterface1.test(1, 2);

        // 对于创建线程的场景，一般是Thread构造方法里new一个Runnable的匿名类，这时候就可以用lambda表达式
        // ()里面是空的，说明方法没有入参。
        Thread thread = new Thread(() -> {
            System.out.println("run method");
        });
        thread.start();


        // 这种情况，我已经有个myTest方法，算是对test的一种实现。
        // 如果我这次new的类，想直接用这个myTest方式的实现，那就可以通过::方式来引用
        // 如果用::这种方式的话，那入参的()就不用写了，方法体也不用写了。相当于直接调用test对象的myTest方法。
        LambdaTest test = new LambdaTest();
        MyInterface myInterface2 = test::myTest;
        myInterface2.test(1, 2);

        // ::还可以用静态方法的实现，这样就不用new对象了，直接用类来调用
        MyInterface myInterface3 = LambdaTest::myTest2;
        myInterface3.test(1, 2);


        // 这里myClass直接new一个ArrayList，作为方法的实现。
        MyClass myClass = () -> new ArrayList();
        myClass.myArrayList();

        // 这种方式和上面的一样，通过类名::new的方式，相当于对new一个类的简化写法。
        MyClass myClass1 = ArrayList::new;
        myClass1.myArrayList();


        // 遍历集合
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5);

        // 不同的遍历方式，一个是直接输出，一个是判断后再输出
        list.forEach(System.out::println);
        list.forEach(element -> {
            if (element % 2 == 0) {
                System.out.println(element);
            }
        });

        // 参考资料：https://www.cnblogs.com/haixiang/p/11029639.html
    }


    /**
     * 加上这个注解，说明接口里的抽象方法只有一个。
     */
    @FunctionalInterface
    public interface MyInterface {
        int test(int a, int b);
    }

    public int myTest(int a, int b) {
        return a + b;
    }

    public static int myTest2(int a, int b) {
        return a - b;
    }

    /**
     * 定义一个类MyClass，里面有个myArrayList方法，这个方法返回一个ArrayList类型的对象。
     */
    public interface MyClass {
        ArrayList myArrayList();
    }

}
