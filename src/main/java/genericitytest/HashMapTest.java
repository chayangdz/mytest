package genericitytest;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Created by chayang on 2017/1/16.
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("1", "a");
        hashMap.put("2", "b");
        hashMap.put("3", "c");

        System.out.println("-------------");
        Set<Entry<String, String>> entrySet = hashMap.entrySet();
        for (Entry<String, String> entry : entrySet) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        System.out.println("-------------");
        Iterator<Entry<String, String>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Entry<String, String> entry = iterator.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        System.out.println("-------------");
        Set<String> keySet = hashMap.keySet();
        for (String key : keySet) {
            System.out.println(key + ":" + hashMap.get(key));
        }
        System.out.println("------all values-------");
        Collection<String> collection = hashMap.values();
        for (String value : collection) {
            System.out.println(value);
        }


    }
}
