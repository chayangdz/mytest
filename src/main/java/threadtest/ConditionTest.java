package threadtest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by chayang on 2017/4/3.
 */
public class ConditionTest {

    private final Lock lock = new ReentrantLock();
    //ReentrantLock的锁绑定多条件。意思为一个锁可以绑定多个条件。
    private final Condition putCondition = lock.newCondition();
    private final Condition getCondition = lock.newCondition();

    private int[] item = new int[3];//定义长度为3的阻塞队列
    private int putStation;//存数的位置
    private int getStation;//取数的位置
    private int count = 0;

    public void put(int obj) throws Exception {
        lock.lock();
        try {
            while (count == item.length - 1) { //不能用if，防止虚假唤醒
                putCondition.await();
            }
            item[putStation] = obj;
            count++;
            System.out.println(Thread.currentThread().getName() + " put " + obj + " count = " + count);
            putStation++;
            if (putStation == item.length) {
                putStation = 0;
            }
            getCondition.signal();
        } finally {
            lock.unlock();
        }
    }

    public Integer get() throws Exception {
        lock.lock();
        int obj;
        try {
            while (count == 0) {
                getCondition.await();
            }
            obj = item[getStation];
            count--;
            System.out.println(Thread.currentThread().getName() + " get " + obj + " count = " + count);
            getStation++;
            if (getStation == item.length) {
                getStation = 0;
            }
            putCondition.signal();
            return obj;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        final ConditionTest conditionTest = new ConditionTest();

        new Thread(new Runnable() {
            public void run() {
                try {
                    for (int i = 0; i < 20; i++) {
                        conditionTest.put(i);
                        Thread.sleep((long) (Math.random() * 1000));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                try {
                    for (int i = 0; i < 20; i++) {
                        conditionTest.get();
                        Thread.sleep((long) (Math.random() * 2000));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }


}
