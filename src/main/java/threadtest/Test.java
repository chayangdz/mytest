package threadtest;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Lock;

/**
 * Created by chayang on 2017/3/9.
 */
public class Test {

    public static int i = 0;

    public static void main(String[] args) {




        /**
         * 直接new一个Thread的子类,然后父类引用指向子类对象,匿名类
         */
        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();
            }
        };

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                System.out.println("new");
            }
        });

        Thread thread1 = new Thread();
        thread1.start();

        new Thread(new Runnable() {
            public void run() {
                System.out.println("runnable");
            }
        }){
            @Override
            public void run() {
                System.out.println("thread");
            }
        }.start();


        Integer i = 0;
        synchronized (i) {
            System.out.println("aaa");
            synchronized (i) {
                System.out.println("bbb");
            }
        }


    }


    public class MyThread extends Thread {
        @Override
        public void run() {
            super.run();
        }
    }

    Thread myThread = new MyThread();





}
