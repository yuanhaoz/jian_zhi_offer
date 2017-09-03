package chapter_sort;

import java.util.Arrays;

/**
 * 如果在面试中有面试官要求你写一个O(n)时间复杂度的排序算法，你千万不要立刻说：这不可能！虽然前面基于比较的排序的下限是O(nlogn)。
 * 但是确实也有线性时间复杂度的排序，只不过有前提条件，就是待排序的数要满足一定的范围的整数，而且计数排序需要比较多的辅助空间。
 * 其基本思想是，用待排序的数作为计数数组的下标，统计每个数字的个数。然后依次输出即可得到有序序列。
 *
 * Created by 18710 on 2017/9/3.
 */
public class CountSort {

    public static void main(String[] args) {
        int[] arr = {5, 3, 4, 8, 2};
        countSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 计数排序：稳定。计数数组的下标为元素的值，计数数组的元素为原数组下标对应元素的出现次数。
     * 时间复杂度：最好为 O(n+k)，最差为 O(n+k)，平均为 O(n+k)。空间复杂度：O(n+k)
     * @param arr 数组
     */
    public static void countSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int max = max(arr);
        int[] countArr = new int[max + 1]; // 计数数组，长度为max+1，这样countArr[max]可以被赋值
        for (int i = 0; i < arr.length; i++) {
            countArr[arr[i]]++;
        }
        int k = 0; // arr新数组的下标
        for (int i = 0; i < countArr.length; i++) {
            for (int j = 0; j < countArr[i]; j++) {
                arr[k++] = i; // 数组的下标i对应着元素，countArr[i]对应着元素出现的个数
            }
        }
    }

    /**
     * 得到数组元素的最大值
     * @param arr 数组
     * @return 最大值
     */
    public static int max(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

}
