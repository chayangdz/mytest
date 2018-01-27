package threadtest;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by chayang on 2017/3/23.
 */
public class LockTest {
    private Map cache = new HashMap<String, Object>();
    public static void main(String[] args) {
        Object object = new LockTest().getData("a");
    }


    private ReadWriteLock rwl = new ReentrantReadWriteLock();

    public Object getData(String key) {
        rwl.readLock().lock();
        Object value = null;
        try {
            value = cache.get(key);
            if (value == null) {
                rwl.readLock().unlock();
                rwl.writeLock().lock();
                if (value == null) {//两次判断，防止多个线程同时加上写锁然后多次给value赋值
                    value = "a";
                }
                rwl.readLock().lock();
                rwl.writeLock().unlock();

            }
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwl.readLock().unlock();
        }
        return value;
    }
}
