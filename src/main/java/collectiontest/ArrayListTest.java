package collectiontest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chayang on 2017/8/30.
 */
public class ArrayListTest {
    public static void main(String[] args) {

        if (true) {
            System.out.println("a");
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        List list1 = list.subList(1, 3);
        for (int i = 0; i < list1.size(); i++) {
            list.add(666);
            System.out.println(list1.get(i));
        }

    }
}
