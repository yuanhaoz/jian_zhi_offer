package chapter_sort;

import java.util.Arrays;

/**
 * 归并排序是另一种不同的排序方法，因为归并排序使用了递归分治的思想，所以理解起来比较容易。
 * 其基本思想是，先递归划分子问题，然后合并结果。把待排序列看成由两个有序的子序列，然后合并两个子序列，然后把子序列看成由两个有序序列。。。。。
 * 倒着来看，其实就是先两两合并，然后四四合并。。。最终形成有序序列。
 *
 * 空间复杂度为O(n)，时间复杂度为O(nlogn)。
 *
 * Created by 18710 on 2017/9/3.
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {5, 3, 4, 8, 2};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 归并排序：稳定。递归分治的实现。
     * 时间复杂度：最好为 O(nlogn)，最差为 O(nlogn)，平均为 O(nlogn)。空间复杂度：O(n)
     * @param arr 数组
     */
    public static void mergeSort(int[] arr){
        if (arr == null || arr.length == 0) {
            return;
        }
        mSort(arr, 0, arr.length - 1); // 归并排序
    }

    /**
     * 归并排序：递归分治
     * @param arr 数组
     * @param left 归并起始下标
     * @param right 归并结束下标
     */
    public static void mSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2; // 中间位置
        mSort(arr, left, mid); // 左半边排序 【left, mid】
        mSort(arr, mid + 1, right); // 右半边排序 【mid + 1, right】
        merge(arr, left, mid, right); // 合并左右两边的排序结果
    }

    /**
     * 合并一趟归并后的数组
     * @param arr 数组
     * @param left 左下标
     * @param mid 中间下标
     * @param right 右下标
     */
    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1]; // 临时数组，保存合并后的两个数组
        int k = 0;
        int i = left; // 左半边数组起始位置
        int j = mid + 1; // 右半边数组起始位置
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) { // 每次保存比较小的那个数
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        // 如果前半个数组没有遍历完
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        // 如果后半个数组没有遍历完
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        // 因为arr的数组是从left开始到right的，所以更新对应的位置上的元素值
        for (int l = 0; l < temp.length; l++) {
            arr[l + left] = temp[l];
        }
    }

}
