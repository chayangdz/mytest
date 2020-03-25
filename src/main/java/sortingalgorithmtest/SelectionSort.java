package sortingalgorithmtest;

/**
 * Created by chayang on 2017/9/12.
 */
public class SelectionSort {
    /**
     * 选择排序，也叫简单选择排序
     * 每次从待排序的记录中选择最小的，与第一个位置交换
     * 需要记录每次遍历的最小值和最小值的位置
     * 选择排序空间复杂度为 O(1)，是一种原地排序算法
     * 选择排序是一种不稳定的排序算法
     */


    private static void selectionSort(int[] a) {
        if (a.length <= 1) {
            return;
        }
        int position;//position记录最小值的位置
        for (int i = 0; i < a.length; i++) {
            position = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[position]) {
                    position = j;
                }
            }
            if (position != i) {
                int temp = a[i];
                a[i] = a[position];
                a[position] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a1 = {5, 4, 3, 2, 1};
        selectionSort(a1);
        for (int a : a1) {
            System.out.print(a);
        }
        System.out.println();
        int[] a2 = new int[]{2, 3, 7, 1, 4, 6, 5};
        selectionSort(a2);
        for (int a : a2) {
            System.out.print(a);
        }

    }
}
