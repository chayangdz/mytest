package threadtest;

/**
 * Created by chayang on 2017/6/25.
 */
public class WaitNotifyTest {
    Monitor monitor = new Monitor();

    public void doWait() throws Exception {
        synchronized (monitor) {
            monitor.wait();
        }
    }

    public void doNotify() throws Exception {
        synchronized (monitor) {
            monitor.notify();
        }
    }
}
