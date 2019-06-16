package proxytest.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by chayang on 2017/11/28.
 */
public class TargetMethodHandler implements InvocationHandler {

    /**
     * 被代理的目标类
     */
    private Object target;

    public TargetMethodHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target, args);
        after();
        return result;
    }

    private void before() {
        System.out.println("before");
    }

    private void after() {
        System.out.println("after");
    }
}
