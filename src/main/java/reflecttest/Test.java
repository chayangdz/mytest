package reflecttest;



import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chayang on 2017/1/2.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        Point p1 = new Point(3, 5);
        new Point(3,5);
        Field field1 = p1.getClass().getField("y");
        System.out.println(field1.get(p1));

        Field field2 = p1.getClass().getDeclaredField("x");
        field2.setAccessible(true);
        System.out.println(field2.get(p1));

        changeString(p1);
        System.out.println(p1);

        Method method = String.class.getMethod("charAt", int.class);
        System.out.println(method.invoke("abc", 1));

        int[] a1 = {1,2};
        String[] s1 = {"1","2"};
        int[][] a2 = {{1,2},{1,2,3}};
        System.out.println(a1.getClass().getName());
        System.out.println(s1.getClass().getName());
        System.out.println(a2.getClass().getName());
        System.out.println(a1.getClass().getSuperclass().getName());


        Point p2 = new Point(3, 5);
        System.out.println(p1 == p2);
        System.out.println(p1.equals(p2));

        String s = (String) Class.forName("java.lang.String").newInstance();
        List list = (List) Class.forName("java.util.ArrayList").newInstance();
        list.add("1");
        System.out.println(list);

        List<Integer> list1 = new ArrayList<Integer>();
        List<String>  list2 = new ArrayList<String>();
        System.out.println(list1.getClass().getName());
        System.out.println(list2.getClass().getName());



//
//        BeanUtils.setProperty(p1, "x", "4");
//        System.out.println(p1.getX());



    }


    private static void changeString(Object obj) throws Exception {
        Field[] fields = obj.getClass().getFields();
        for (Field field : fields) {
            if (field.getType() == String.class) {
                String s = (String) field.get(obj);
                field.set(obj, s.replace("b", "a"));
            }
        }
    }




}

