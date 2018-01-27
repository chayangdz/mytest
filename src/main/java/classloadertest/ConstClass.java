package classloadertest;

/**
 * Created by chayang on 2017/10/2.
 */
public class ConstClass {
    static {
        System.out.println("ConstClass init");
    }

    public static final String HELLO = "hello";


}
