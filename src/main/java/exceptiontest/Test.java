package exceptiontest;

/**
 * Created by chayang on 2017/9/20.
 */
public class Test {

    private static int test() {
        try {
            return 1;
//            System.out.println("try");
        }catch (Throwable e) {

        } finally {
            System.out.println("finally");
            return 2;
        }

    }

    public static void main(String[] args) {
        int i = test();
        System.out.println(i);


        try {
            int[] a = {1,2,3};
            for (int j =0;j<5;j++) {
                System.out.println(a[j]);
            }
        }catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
