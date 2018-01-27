package proxytest;

import proxytest.impl.MyAdvice;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by chayang on 2017/2/23.
 */
public class Test {
    public static void main(String[] args) throws Exception {

        /**
         * 创建一个代理类字节码
         */
        Class clazz = Proxy.getProxyClass(List.class.getClassLoader(), List.class);
        System.out.println(clazz.getName());



        /**
         * 打印方法
         *
         * StringBuilder 效率高，单线程
         * StringBuffer 效率低，多线程
         */
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            String constructorName = constructor.getName();
            StringBuilder stringBuilder = new StringBuilder(constructorName);
            stringBuilder.append("(");
            Class[] clazzParameters = constructor.getParameterTypes();
            for (Class clazzParameter : clazzParameters) {
                stringBuilder.append(clazzParameter).append(",");
            }
            if (stringBuilder.charAt(stringBuilder.length() - 1) == ',') {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            stringBuilder.append(")");
            System.out.println(stringBuilder);
        }


        /**
         * 拿到代理类的构造方法
         */
        Constructor constructor = clazz.getConstructor(InvocationHandler.class);

        /**
         * 通过构造方法新建对象 方法一
         */
        List list = (List) constructor.newInstance(new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        });


        /**
         * 通过构造方法新建对象 方法二
         */
        class MyInvocationHandler implements InvocationHandler {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        }
        List list1 = (List) constructor.newInstance(new MyInvocationHandler());


        /**
         * 直接通过Proxy类的方法创建代理类对象
         */
        final List target = new ArrayList();
        List list2 = (List) getProxy(target, new MyAdvice());

        list2.add(1);

        /**
         * new一个接口，就相当于new了一个接口的实现类
         */
        Advice myAdvice = new Advice() {
            public void beforeMethod(Method method) {

            }

            public void afterMethod(Method method) {

            }
        };


    }

    /**
     * 创建个代理，需要classLoader，Interfaces，InvocationHandle
     * 换个角度理解，创建代理，需要知道这个代理类去代理哪个目标，在执行目标方法的前后，需要加入哪些功能。
     * 之前用Proxy.newProxyInstance创建代理类的时候，代理的目标和前后的方法都需要写在里面。
     * 现在抽出 target和advice参数之后，就灵活了
     */

    private static Object getProxy(final Object target, final Advice advice) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                    target.getClass().getInterfaces(),
                    new InvocationHandler() {
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                            return method.invoke(proxy, args);//死循环
                            advice.beforeMethod(method);
                            Object returnVal =  method.invoke(target, args);
                            advice.afterMethod(method);
                            return returnVal;
                        }
                    }
            );
    }
}