package chapter_sort;

import java.util.Arrays;

/**
 * 冒泡排序：
 *
 * 冒泡排序是最简单的排序之一了，其大体思想就是通过与相邻元素的比较和交换来把小的数交换到最前面。
 * 这个过程类似于水泡向上升一样，因此而得名。举个例子，对5,3,8,6,4这个无序序列进行冒泡排序。
 * 首先从后向前冒泡，4和6比较，把4交换到前面，序列变成5,3,8,4,6。同理4和8交换，变成5,3,4,8,6,3和4无需交换。
 * 5和3交换，变成3,5,4,8,6,3.这样一次冒泡就完了，把最小的数3排到最前面了。对剩下的序列依次冒泡就会得到一个有序序列。
 *
 * 冒泡排序的时间复杂度为O(n^2)。
 *
 * Created by 18710 on 2017/9/2.
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {5, 3, 4, 8, 6};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡排序：稳定。属于交换排序算法的一种，另外一种是快速排序。
     * 时间复杂度：最好为 O(n^2)，最差为 O(n^2)，平均为 O(n^2)。空间复杂度：O(1)
     * @param arr 数组
     */
    public static void bubbleSort(int[] arr){
        if (arr == null || arr.length == 0) { // 数组为null或者没有元素
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) { // 从第一个元素到倒数第二个元素
            for (int j = arr.length - 1; j > i; j--) { // 从最后一个元素到当前元素之前的那个元素
                if (arr[j] < arr[j - 1]) { // 比较每个元素和之前的元素，后面的元素小的话就交换冒泡
                    Swap.swap(arr, j, j - 1);
                }
            }
        }
    }

}
