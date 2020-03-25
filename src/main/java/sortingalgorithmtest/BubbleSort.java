package sortingalgorithmtest;

/**
 * Created by chayang on 2017/9/12.
 */
public class BubbleSort {
    /**
     * 冒泡排序
     * 两两比较，如果前面比后面大，则交换。
     * 小的上浮，大的下沉
     * 第一轮循环完成之后，最大的数在最后，第二轮之后，第二大的数在倒数第二
     *
     *
     * 冒泡排序属于原地排序算法，空间复杂度为O(1)
     * 冒泡排序是稳定的排序算法
     */


    private static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i -1; j++) {
                if (a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }

    /**
     * 增加一个flag，在某次比较后没有交换数据的情况下，提前结束循环
     * @param a
     */
    private static void bubbleSort2(int[] a) {
        for (int i = 0; i < a.length; i++) {
            boolean flag = false;
            for (int j = 0; j < a.length - i -1; j++) {
                if (a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] a1 = {8, 2, 3, 1, 6, 4, 5, 7};
//        bubbleSort(a1);
        bubbleSort2(a1);
        for (int a : a1) {
            System.out.print(a);
        }
    }
}
