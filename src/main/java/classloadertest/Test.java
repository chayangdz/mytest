package classloadertest;

/**
 * Created by chayang on 2017/2/6.
 */
public class Test {
    public static void main(String[] args) {
//        System.out.println(Test.class.getClassLoader());
//        System.out.println(Test.class.getClassLoader().getClass().getName());
//        System.out.println(System.class.getClassLoader());

        System.out.println(ConstClass.HELLO);
    }
}
