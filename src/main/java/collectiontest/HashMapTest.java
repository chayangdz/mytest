package collectiontest;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by chayang on 2017/7/7.
 */
public class HashMapTest {
    public static void main(String[] args) {
        Map<String, String> testMap = new HashMap<String, String>();
        testMap.put("1", "a");
        testMap.put("2", "b");
        testMap.put("3", "c");
        /**
         * 第一种遍历方式
         * 推荐
         */
        for (Map.Entry<String, String > entry : testMap.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        /**
         * 第二种遍历方式
         * 推荐
         *
         */
        Iterator<Map.Entry<String, String>> iterator = testMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        /**
         * 第三种遍历方式
         * 不推荐
         */
        for (String key : testMap.keySet()) {
            System.out.println(key);
            System.out.println(testMap.get(key));
        }
        /**
         * 第四种遍历方式
         * 只能遍历所有的value
         */
        for (String value : testMap.values()) {
            System.out.println(value);
        }

        /**
         * 可以通过Collections.synchronizedMap把map变成线程安全的
         */
        Map map = Collections.synchronizedMap(testMap);
    }
}
