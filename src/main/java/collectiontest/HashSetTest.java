package collectiontest;

import java.util.HashSet;

/**
 * Created by chayang on 2017/8/17.
 */
public class HashSetTest {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<String>();
        hashSet.add(null);
        System.out.println(hashSet.size());
    }
}
