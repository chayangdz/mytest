package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
 *
 * @author zhayang <zhayang@kuaishou.com>
 * Created on 2022-10-05
 */
public class MaxRepeatSubString {

    /**
     * 思路：滑动窗口
     * 维持left和right的指针，并且定义一个集合来存储当前遍历到的最长子串
     * 如果集合中不包含重复字符，然后right右移，继续查找，则当前的集合大小就是目前遍历到的最长子串长度
     * 如果集合中包含重复字符，则从set中删除left指针对应的元素，并且left右移，直到set中不包含重复元素
     */
    public static int longestSubStringLength(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int maxLength = 0;
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                //未查到重复字符就一直加，right右移
                set.add(s.charAt(right));
                right++;
                maxLength = Math.max(maxLength, set.size());
            } else {
                //right查到重复字符先不动，left右移，set删left经过的字符，直到重复的这个字符删掉为止
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxLength;
    }


    public static void main(String[] args) {
        String s = "pwwkewt";
        int length = longestSubStringLength(s);
        System.out.println(length);
    }
}
