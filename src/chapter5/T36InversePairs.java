package chapter5;

/**
 * 面试题36：数组中的逆序对（归并排序）
 * 题目：在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组成一对逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 * 思路：
 * 1. 顺序扫描整个数组，没扫描到一个数字的时候，逐个比较该数字和它后面的数字的大小。如果后面的数字比它小，则这两个数字就组成了一个逆序对。假设数组中含有n个数字。
 *    由于每个数字要和O(n)个数字作比较，因此这个算法的时间复杂度是O(n^2)。
 * 2. 先把数组分隔成子数组，先统计出子数组内部的逆序对的数目，然后再统计出两个相邻子数组之间的逆序对的数目。在统计逆序对的过程中，还需要对数组进行排序。如果对排序
 *    算法很熟悉，不难发现这个排序过程实际上就是归并排序。时间复杂对是O(nlogn)，空间复杂度是O(n)，空间换时间的算法。
 *
 * Created by 18710 on 2017/8/25.
 */
public class T36InversePairs {

    public static void main(String[] args) {
        int[] data = {7, 5, 6, 4};
        System.out.println(inversePairs(data));
    }

    /**
     * 数组中的逆序对：归并排序
     * @param data 数组
     * @return
     */
    public static int inversePairs(int[] data) {
        if (data == null || data.length == 0) {
            return 0;
        }
        int[] copy = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            copy[i] = data[i];
        }
        return inversePairs(data, copy, 0, data.length - 1);
    }

    /**
     * 归并排序分别求得左右两段逆序对个数和两段之间逆序对个数
     * @param data 数组
     * @param copy 辅助数组
     * @param start 起始位置
     * @param end 结束位置
     * @return
     */
    public static int inversePairs(int[] data, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = data[start];
            return 0;
        }
        int mid = (end - start) / 2;
        int left = inversePairs(copy, data, start, start + mid); // 注意copy和data每次归并需要交换，因为下一次归并是针对排序好的上一次归并的结果来的
        int right = inversePairs(copy, data, start + mid + 1, end);
        int i = start + mid; // 前半段的最后一个元素下标
        int j = end; // 后半段的最后一个元素下标
        int indexCopy = end; // 辅助数组的下标
        int count = 0; // 两段之间存在的逆序对个数
        while (i >= start && j >= start + mid + 1) {
            if (data[i] > data[j]) { // 前一个数比后一个数大，则将前一个数放到辅助数组中保证有序，并且逆序对次数加上右边元素个数
                copy[indexCopy--] = data[i--];
                count += j - start - mid;
            } else { // 前一个数比后一个数小，则将后一个数放到辅助数组中保证有序，此时不存在逆序对
                copy[indexCopy--] = data[j--];
            }
        }
        // 对前半段剩余元素放到逆序对中
        for (; i >= start; --i) {
            copy[indexCopy--] = data[i];
        }
        // 对后半段剩余元素放到逆序对中
        for (; j >= start + mid + 1; --j) {
            copy[indexCopy--] = data[j];
        }
        return left + right + count; // 最终返回的是:前半段中逆序对个数+后半段中逆序对个数+两段之间逆序对个数
    }

}
