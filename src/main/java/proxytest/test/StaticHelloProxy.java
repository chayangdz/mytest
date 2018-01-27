package proxytest.test;

/**
 * Created by chayang on 2017/11/28.
 */
public class StaticHelloProxy implements Hello{
    private Hello hello;

    public StaticHelloProxy() {
        this.hello = new HelloImpl();
    }

    public void say() {
        before();
        hello.say();
        after();
    }

    private void before() {
        System.out.println("before");
    }

    private void after() {
        System.out.println("after");
    }
}
