package collectiontest;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by chayang on 2017/8/13.
 */
public class CopyOnWriteArrayListTest {


    public static void main(String[] args) {
//        List<String> copyOnWriteArrayList = new CopyOnWriteArrayList<String>();
//        copyOnWriteArrayList.add("a");
//        copyOnWriteArrayList.get(0);

        List<Integer> list = new Vector<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        Thread1 thread1 = new Thread1(list);
        Thread2 thread2 = new Thread2(list);
        thread1.start();
        thread2.start();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("遍历list:");
        for (Integer i : list) {
            System.out.print(i + ",");
        }

    }

    public static class Thread1 extends Thread {
        private List<Integer> list;

        public Thread1(List<Integer> list) {
            this.list = list;
        }

        @Override
        public void run() {
            System.out.println("通过foreach对list进行迭代--begin");
            for (Integer i : list) {
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("获取元素:" + i);
                System.out.println("list的size:" + list.size() + ",list的hashCode:" + list.hashCode());
            }
            System.out.println("通过foreach对list进行迭代--end");
        }
    }

    public static class Thread2 extends Thread {
        private List<Integer> list;

        public Thread2(List<Integer> list) {
            this.list = list;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(50);
                for (int i = 10; i < 20; i++) {
                    list.add(i);
                    Thread.sleep(100);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
