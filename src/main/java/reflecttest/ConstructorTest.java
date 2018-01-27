package reflecttest;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by chayang on 2016/12/31.
 */
public class ConstructorTest {
    public static void main(String[] args) throws Exception {
        Constructor constructor = String.class.getConstructor(StringBuffer.class);
        String s = (String) constructor.newInstance(new StringBuffer("123"));
        System.out.println(s);

        ArrayList<String> arrayList3 = new ArrayList(); // 不报错
        ArrayList arrayList4 = new ArrayList<String>(); // 不报错


        ArrayList arrayList = new ArrayList<String>();
        ArrayList<Integer> arrayList1 = arrayList;

        ArrayList<String> arrayList2 = new ArrayList<String>();
//        ArrayList<Integer> arrayList5 = arrayList2; // 报错

        ArrayList<? extends Number>  arrayList5 = new ArrayList<Integer>();
//        ArrayList<? extends Number>  arrayList6 = new ArrayList<String>();

        Class.class.asSubclass(Number.class);

    }
}
