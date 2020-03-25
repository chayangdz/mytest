/**
 * Created by chayang on 2016/12/19.
 */
public class AutoBox {
    public static void main(String[] args) {
        /**
         * Integer i1 = 1; 自动装箱，把int类型的1，包装成Integer类型的对象
         * 如果Integer类型的变量和int类型值相加，则会自动拆箱，先把Integer变成普通类型。
         * 自动装箱，相当于调用Integer.valueOf()
         * 自动装箱会对-128~127之间的数进行特殊处理，放在缓存里，内存中只有一份
         */
        Integer i1 = 1;
        Integer i2 = 1;
        Integer x = i1 + 2;
        System.out.println("x=" + x);

        System.out.println("i1==i2?" + (i1 == i2));

        /**
         * 如果是new Integer(1)，则是新建对象，不会有自动装箱的操作
         */
        Integer i3 = new Integer(1);
        Integer i4 = new Integer(1);
        System.out.println("i3==i4?" + (i3 == i4));

        Integer i5 = 128;
        Integer i6 = 128;
        System.out.println("i5==i6?" + (i5 == i6));

        Integer i7 = Integer.valueOf(1);
        Integer i8 = Integer.valueOf(1);
        System.out.println("i7==i8?" + (i7 == i8));


        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Long g = 3L;

        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));

        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b));

    }
}
