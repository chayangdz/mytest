package proxytest;

import java.lang.reflect.Method;

/**
 * Created by chayang on 2017/3/9.
 */
public interface Advice {
    void beforeMethod(Method method);
    void afterMethod(Method method);
}
