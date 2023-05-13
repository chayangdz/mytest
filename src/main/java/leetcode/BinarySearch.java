package leetcode;

import java.math.BigDecimal;

/**
 * @author zhayang <zhayang@kuaishou.com>
 * Created on 2020-10-18
 */
public class BinarySearch {

    /**
     * 题目：
     * 数组的元素，先减小，再增大。
     * 找到数组中最小的元素
     */
    public static void main(String[] args) {
        int[] a = {9, 8, 7, 6, 5, 3, 1, 4, 6, 9};
        int result = binarySearch(a);
        System.out.println(result);

        BigDecimal bigDecimal = new BigDecimal(2.9);
        System.out.println(bigDecimal.longValue());
    }


    public static int binarySearch(int[] a) {
        int low = 0;
        int high = a.length - 1;
        while (low < high) {
            // 如果这里mid计算写成了 (low+high)/2的话，有可能导致溢出
            int mid = low + (high - low) / 2;
            if (a[mid] < a[mid + 1]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return a[low];
    }
}
