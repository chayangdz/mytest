package leetcode;

/**
 * 字符串相加
 *
 * @author zhayang <zhayang@kuaishou.com>
 * Created on 2022-10-05
 */
public class AddStrings {


    /**
     * 思路：定义两个指针，i和j，指向两个字符串的末尾，也就是数字的最低位
     * 定义一个变量add，记录相加之后的进位
     */
    private static String addStrings(String s1, String s2) {
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int add = 0;
        StringBuilder builder = new StringBuilder();
        while (i > 0 || j > 0 || add > 0) {
            int x = i >= 0 ? s1.charAt(i) - '0' : 0;
            int y = j >= 0 ? s2.charAt(j) - '0' : 0;
            int result = x + y + add;
            builder.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        String s1 = "12345000000000000000";
        String s2 = "66867890000000000000000";
        String result = addStrings(s1, s2);
        System.out.println(result);
    }
}
