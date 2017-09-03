package chapter_sort;

import java.util.Arrays;

/**
 * 交换数组的元素
 *
 * Created by 18710 on 2017/9/2.
 */
public class Swap {

    public static void main(String[] args) {
        int[] arr = {5, 3, 4, 8, 6};
        swap(arr, 0, 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 交换数组指定位置上两个数的值
     * @param arr 数组
     * @param i 第一个数字在数组的下标
     * @param j 第二个数字在数组的下标
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
