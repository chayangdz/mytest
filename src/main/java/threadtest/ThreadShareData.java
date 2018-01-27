package threadtest;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by chayang on 2017/3/17.
 */
public class ThreadShareData {

    private static int data = 0;

    private static Map<Thread, Integer>  map = new HashMap<Thread, Integer>();

    public static void main(String[] args) {

        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                public void run() {
                    int data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName() + " set value:" + data);
                    map.put(Thread.currentThread(), data);
                    new A().get();
                    new B().get();
                }
            }).start();
        }

    }
    static class A {
        public void get() {
            int data = map.get(Thread.currentThread());
            System.out.println("A " + Thread.currentThread().getName() + " get value:" + data);
        }
    }
    static class B {
        public void get() {
            int data = map.get(Thread.currentThread());
            System.out.println("B " + Thread.currentThread().getName() + " get value:" + data);
        }
    }
}
