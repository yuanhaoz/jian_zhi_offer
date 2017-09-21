package chapter_sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * 快速排序
 * 通过一趟排序将待排记录分割成独立的两部分，其中一部记录的关键均比另一部分记录的关键字小，则可分别对这两部分记录继续进行排序。
 * 快速排序一听名字就觉得很高端，在实际应用当中快速排序确实也是表现最好的排序算法。
 * 快速排序虽然高端，但其实其思想是来自冒泡排序，冒泡排序是通过相邻元素的比较和交换把最小的冒泡到最顶端，
 * 而快速排序是比较和交换小数和大数，这样一来不仅把小数冒泡到上面同时也把大数沉到下面。
 * 举个例子：对5,3,8,6,4这个无序序列进行快速排序，思路是右指针找比基准数小的，左指针找比基准数大的，交换之。
 * 5,3,8,6,4 用5作为比较的基准，最终会把5小的移动到5的左边，比5大的移动到5的右边。
 * 5,3,8,6,4 首先设置i,j两个指针分别指向两端，j指针先扫描（思考一下为什么？）4比5小停止。然后i扫描，8比5大停止。交换i,j位置。
 * 5,3,4,6,8 然后j指针再扫描，这时j扫描4时两指针相遇。停止。然后交换4和基准数。
 * 4,3,5,6,8 一次划分后达到了左边比5小，右边比5大的目的。之后对左右子序列递归排序，最终得到有序序列。
 * 上面留下来了一个问题为什么一定要j指针先动呢？首先这也不是绝对的，这取决于基准数的位置，因为在最后两个指针相遇的时候，要交换基准数到相遇的位置。
 * 一般选取第一个数作为基准数，那么就是在左边，所以最后相遇的数要和基准数交换，那么相遇的数一定要比基准数小。所以j指针先移动才能先找到比基准数小的数。
 * 快速排序是不稳定的，其时间平均时间复杂度是O(nlgn)。
 * 总结快速排序的思想：冒泡 + 二分 + 递归分治，慢慢体会。
 *
 * Created by 18710 on 2017/9/2.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {5, 3, 4, 8, 2};
//        sort(arr);
        quickSortNonRec(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 快速排序：不稳定。冒泡 + 二分 + 递归分治。
     * 时间复杂度：最好为 O(nlogn)，最差为 O(n^2)，平均为 O(nlogn)。空间复杂度：O(logn)
     * @param arr 数组
     */
    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 快速排序
     * @param arr 数组
     * @param left 左指针
     * @param right 右指针
     */
    public static void quickSort(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        int pos = partition(arr, left, right); // 每次得到基准值的位置
        quickSort(arr, left, pos - 1); // 分别对数组的左右子数组重复快排调用
        quickSort(arr, pos + 1, right);
    }

    /**
     * 每次得到基准值下标，并进行一次排序
     * @param arr 数组
     * @param left 左指针
     * @param right 右指针
     * @return 基准值下标
     */
    public static int partition(int[] arr, int left, int right) {
        int temp = arr[left]; // 保存基准值
        while (left < right) {
            while (left < right && arr[right] > temp) { // 从右向左开始循环遍历
                right--;
            }
            arr[left] = arr[right]; // 左边的值都比基准值小
            while (left < right && arr[left] < temp) { // 从左向右开始循环遍历
                left++;
            }
            arr[right] = arr[left]; // 右边的值都比基准值大
        }
        arr[left] = temp;
        return left;
    }

    /**
     * 非递归实现
     * @param arr 数组
     */
    public static void quickSortNonRec(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        Stack<Integer> stack = new Stack<>(); // 用一个栈保存每次循环的子数组范围
        stack.add(0);
        stack.add(arr.length - 1);
        while (!stack.isEmpty()) {
            int right = stack.pop();
            int left = stack.pop();
            int pos = partition(arr, left, right);
            if (pos - 1 > left) {
                stack.add(left);
                stack.add(pos - 1);
            }
            if (pos + 1 < right) {
                stack.add(pos + 1);
                stack.add(right);
            }
        }
    }

}
