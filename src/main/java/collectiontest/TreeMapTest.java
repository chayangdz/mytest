package collectiontest;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by chayang on 2017/8/13.
 */
public class TreeMapTest {

    /**
     * TreeMap采用红黑树实现的,可以对key进行排序
     *
     */

    public static void main(String[] args) {

        TreeMap<Integer, String> map = new TreeMap<Integer, String>();
        map.put(1, "1");
        map.put(3, "3");
        map.put(6, "6");
        map.put(5, "5");
        map.put(2, "2");
        map.put(4, "4");
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(map.get(iterator.next()));
        }

        Iterator<Map.Entry<Integer, String>> iterator1 = map.entrySet().iterator();
        while (iterator1.hasNext()) {
            Map.Entry<Integer, String> entry = iterator1.next();
            System.out.println("key:" + entry.getKey() + ",value:" + entry.getValue());
        }


        TreeMap<Integer, String> compareMap = new TreeMap<Integer, String>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
    }
}
