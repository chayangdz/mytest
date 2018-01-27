package collectiontest;


import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by chayang on 2017/7/9.
 */
public class ListTest {
    public static void main(String[] args) {

        List<String> arrayList = new ArrayList<String>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");


        /**
         * 普通for循环遍历
         */
        for(int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i);
        }

        /**
         * foreach方式遍历，在编译的时候编译器会自动将对for这个关键字的使用转化为对目标的迭代器的使用，相当于Iterator
         */
        for (String s : arrayList) {
        }

        /**
         * 对于ArrayList，普通for循环遍历方式效率比采用foreach遍历方式效率高
         * 对于LinkedList，普通for循环遍历方式比foreach遍历方式效率低，并且是采用for循环遍历方式的效率极低，要避免使用。
         * 在ArrayList和LinkedList都采用各自遍历效率最高的方式时，ArrayList的遍历效率会比LinkedList的遍历效率高一些
         */


        /**
         * ArrayList是非线程安全的
         * 可以使用Collections.synchronizedList(list)来把list变成线程安全的。或者使用Vector
         */
        List<String> synchronizedList = Collections.synchronizedList(arrayList);
        synchronizedList.add("a");
        synchronizedList.add("b");
        System.out.println(synchronizedList);




        /**
         * LinkedList是双向链表，里面有内部类Node，用来存放数据。
         */
        List<String> linkedList = new LinkedList<String>();
        linkedList.add("a");
        linkedList.add("b");

        /**
         * 普通for循环遍历
         */
        for (int i = 0; i < linkedList.size(); i++) {
            linkedList.get(i);
        }

        /**
         * foreach方式遍历
         */
        for (String s : linkedList) {

        }

        linkedList.get(1);
        linkedList.remove(1);



        /**
         * Vector可以看成是ArrayList的线程安全版本，其实现90%和ArrayList都完全一样
         */
        Vector<String> vector = new Vector<String>();







    }


}
