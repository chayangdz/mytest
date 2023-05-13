package programtest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * 删除奇数
 * @author zhayang <zhayang@kuaishou.com>
 * Created on 2022-10-05
 */
public class ArrayListTest {

    private static void removeArr(List<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next % 2 == 1) {
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        for (int i=1;i<=100;i++){
            list.add(i);

        }
//        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);
        removeArr(list);
        System.out.println(list.toString());
    }
}
