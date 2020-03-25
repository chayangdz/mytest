package sortingalgorithmtest;

/**
 * Created by chayang on 2017/9/12.
 */
public class QuickSort {
    /**
     * 快速排序，采用分而治之的思想
     * 取头元素为参照，第一次排序后，分成两部分，前面的都比参照数小，后面的都比参照数大
     * 以此类推，对参照数前后的两部分继续进行快速排序
     *
     * 快排的时间复杂度是 O(n*log n)
     */

    private static void quickSort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int i = low;
        int j = high;//low和high的值，要保留
        int temp = a[i];
        while (i < j) {
            while (i < j && a[j] >= temp) {
                j--;
            }
            if (i < j) {
                a[i] = a[j];
                i++;
            }
            while (i < j && a[i] < temp) {
                i++;
            }
            if (i < j) {
                a[j] = a[i];
                j--;
            }
        }
        a[i] = temp;
        sort(a, low, i - 1);
        sort(a, i + 1, high);
    }

    public static void main(String[] args) {
        int[] a1 = {8, 2, 3, 1, 6, 4, 5, 7};
        quickSort(a1);
        for (int a : a1) {
            System.out.print(a);
        }
    }
}
