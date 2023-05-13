package programtest;

import java.util.Stack;

/**
 * @author zhayang <zhayang@kuaishou.com>
 * Created on 2022-10-04
 */
public class BracketsMatch {

    /**
     * 题目，给定字符串，仅包含左括号和右括号，找出最长匹配的括号子串。
     * ()()  ->  4
     * ())   ->  2
     * ()(()) -> 6
     */

    public static void main(String[] args) {
        String s = "()(()";
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        int maxLength = 0;
        int currentLength = 0;
        for (char aChar : chars) {
            if ("(".equals(String.valueOf(aChar))) {
                stack.push(aChar);
            } else {
                if (stack.isEmpty()) {
                    if (currentLength > maxLength) {
                        maxLength = currentLength;
                    }
                    currentLength = 0;
                    continue;
                }
                stack.pop();
                currentLength += 2;
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }
            }
        }
        if (currentLength > maxLength) {
            maxLength = currentLength;
        }
        System.out.println(maxLength);
    }

}
