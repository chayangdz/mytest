package proxytest.test;

import java.lang.reflect.Proxy;

/**
 * Created by chayang on 2017/11/28.
 */
public class Test {
    public static void main(String[] args)  {
        Hello staticHelloProxy = new StaticHelloProxy();
        staticHelloProxy.say();

        Hello hello = new HelloImpl();
        TargetMethodHandler targetMethodHandler = new TargetMethodHandler(hello);
        Hello helloDynamicProxy = (Hello) Proxy.newProxyInstance(
                hello.getClass().getClassLoader(),
                hello.getClass().getInterfaces(),
                targetMethodHandler
        );
        helloDynamicProxy.say();
    }
}
