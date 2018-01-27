package sortingalgorithmtest;

/**
 * Created by chayang on 2017/9/12.
 */
public class InsertionSort {
    /**
     * 插入排序，也叫直接插入排序
     * 每次从待排序的序列中，选择第一个，然后插入前面的有序序列中
     * 比较过程中，要挪动数组，不然以后插入的时候还需要再次挪动
     */


    private static void insertionSort(int[] a) {
        if (a.length <= 1) {
            return;
        }
        for (int i = 1; i < a.length; i++) {
            int j = i - 1;
            int temp = a[i];
            while (j >= 0 && a[j] > temp) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] a1 = {8, 2, 3, 1, 6, 4, 5, 7};
        insertionSort(a1);
        for (int a : a1) {
            System.out.print(a);
        }
    }
}
