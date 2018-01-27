package collectiontest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by chayang on 2017/8/12.
 */
public class ListRemoveTest {

    public static void main(String[] args) {

        List<String> removeList = new ArrayList<String>();
        removeList.add("a");
        removeList.add("b");
        removeList.add("c");
        removeList.add("d");
        for (int i = 0; i < removeList.size(); i++) {
            removeList.remove(i);
        }
        /**
         * 此时打印list的size为1，因为当i=0时，remove掉了第一个元素，之后list就变了，元素往前移动
         * 再remove(1)的时候，其实1的位置已经没有元素了，那个元素又移动到了0的位置。
         * 而且需要注意，list的size也是一直动态变化的，所以下面那种一直remove(0)的方法也不好使，因为size变小了
         */
        System.out.println(removeList);

        for (int i = 0; i < removeList.size(); i++) {
            removeList.remove(0);
        }
        System.out.println(removeList.size());


        List<String> iteratorList = new ArrayList<String>();
        iteratorList.add("1");
        iteratorList.add("2");
        iteratorList.add("3");
        Iterator iterator = iteratorList.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        System.out.println(iteratorList.size());

    }

}
