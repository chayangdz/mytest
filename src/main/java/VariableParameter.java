/**
 * Created by chayang on 2016/12/14.
 */
public class VariableParameter {

    /**
     * 可变参数只能位于参数列表的最后
     * ...前后有无空格都可以
     * 调用含有可变参数的方法时，编译器会为该可变参数创建一个隐含的数组
     * 访问可变参数的时候，以数组的形式访问。
     */

    private static int add(int x, int ... params) {
        int sum = x;
        for (int m : params) {
            sum += m;
        }
        return sum;
    }

    public static void main(String[] args) {
        int result = add(1);
        System.out.println(result);
        result = add(1,2);
        System.out.println(result);
        result = add(1,2,3,4,5,6,7,8);
        System.out.println(result);
    }
}
