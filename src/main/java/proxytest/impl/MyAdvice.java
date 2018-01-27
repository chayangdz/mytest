package proxytest.impl;

import proxytest.Advice;

import java.lang.reflect.Method;

/**
 * Created by chayang on 2017/3/9.
 */
public class MyAdvice implements Advice {

    public void beforeMethod(Method method) {
        System.out.println("before");
    }

    public void afterMethod(Method method) {
        System.out.println("after");
    }
}
