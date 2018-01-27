package genericitytest;

import java.util.ArrayList;


/**
 * Created by chayang on 2017/8/28.
 */
public class GenericTest {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<String>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        System.out.println(list1.getClass() == list2.getClass());
        System.out.println(list1.getClass());
    }

}
