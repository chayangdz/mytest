package proxytest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by chayang on 2017/8/30.
 */
public class ProxyTest {

    public static void main(String[] args) throws Exception {
        /**
         * 可以调用Proxy.getProxyClass创建一个代理类
         * 需要有两个入参，一个是这个代理类的ClassLoader，还有是这个代理类要实现哪些接口
         * 创建的代理类可以实现多个接口，所以入参interfaces是个可变参数
         * 之后通过这个代理类的构造方法，创建代理类的实例对象
         * 因为代理类实现了Collection接口，所以创建出的实例对象，可以看成是一个Collection
         */
        Class proxyClass = Proxy.getProxyClass(Collection.class.getClassLoader(), Collection.class);
        System.out.println(proxyClass.getConstructors());

        Constructor constructor = proxyClass.getConstructor(InvocationHandler.class);
        Collection collection = (Collection) constructor.newInstance(new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        });
        collection.clear();

        /**
         * 上面这段代码通过JVM创建代理类的实例对象，用了两步
         * 第一步，创建了一个代理类
         * 第二步，通过代理类的构造方法，创建实例对象
         * 其实，Proxy里面还有newProxyInstance方法，可以一步就创建出代理类的实例对象
         */
        Collection collection2 = (Collection) Proxy.newProxyInstance(
                Collection.class.getClassLoader(),
                new Class[]{Collection.class},
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        return null;
                    }
                }
        );
        collection2.add("a");

        /**
         * 上面只是创建了动态类，但是并没有指定目标类
         * 既然代理类实现了Collection接口，那就可以指定一个实现Collection接口的目标类
         * 定义了一个ArrayList的目标类
         * 当调用代理类的方法时，实际上是调用了InvocationHandler中的invoke方法
         * 这个invoke方法，就会去调用目标类的方法，并且在调用方法前后加上其它实现方法
         * 调用目标类的方法，是通过反射来实现的，所以invoke方法需要的参数有method和args
         * 通过method.invoke(target, args)，就可以调用目标类的method方法
         */
        Collection collection3 = (Collection) Proxy.newProxyInstance(
                Collection.class.getClassLoader(),
                new Class[]{Collection.class},
                new InvocationHandler() {
                    List<String> list = new ArrayList<String>();
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println(proxy.getClass().getName());
                        System.out.println("begin");
                        Object result = method.invoke(list, args);
                        System.out.println("end");
                        return result;
                    }
                }
        );
        /**
         * 当调用collection3.add("1");的时候，有三个信息
         * 一个是代理对象，也就是collection3
         * 一个是调用哪个方法，也就是add
         * 一个是传递了什么参数，也就是"1"
         * 而实际会调用InvocationHandler的invoke方法
         * 所以，InvocationHandler的三个入参
         * Object proxy 代表这个代理对象
         * Method method 代表调用的哪个方法
         * Object[] args 代表传递了什么参数
         */
        collection3.add("1");
        collection3.add("2");
        collection3.add("3");
        System.out.println(collection3.size());


    }
}
/**
 * 动态代理：
 * 两个类，一个代理类，一个目标类，这两个类实现相同的接口，这样就会暴露出相同的方法。
 * 本来应该去调用目标类的，但是现在改成去调用代理类，代理类中，再去调用目标类的方法，并且在调用之前和之后再加点别的代码，就动态代理了。
 * 不过实际写代码时，还需要面向接口编程，定义接口指向具体的实现类对象。
 */