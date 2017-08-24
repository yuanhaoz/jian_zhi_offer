package chapter5;

import java.util.Comparator;

/**
 * 面试题33：把数组排成最小的数
 * 题目：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3,32,321}，则打印出这3个数字能排成的最小数字321323。
 *
 * 思路：
 * 本题希望我们能找到一个排序规则，数组根据这个规则排序之后能排成一个最小的数字。要确定排序规则，就要比较两个数字。
 * 两个数字m和n能拼接成数字mn和nm。如果mn<nm，那么我们应该打印出mn，也就是m应该排在n的前面，我们定义此时m小于n;
 * 反之，如果nm<mn，我们定义n小于m。如果mn=nm，m等于n。
 *
 * 本题考点：
 * 本题有两个难点：第一个难点是想出一种新的比较规则来排序一个数组；第二个难点在于证明这个比较规则是有效的，并且
 * 证明根据这个规则排序之后把数组中所有数字拼接起来得到的数字是最小的。要求很强的数学功底和逻辑思维能力。
 * 考查解决大数问题的能力。应聘者在面试的时候要意识到，把两个int型的整数拼接起来得到的数字可能会超出int型
 * 数字能够表达的范围，从而导致数字溢出。我们可以用字符串表示数字，这样就能简洁地解决大数问题。
 *
 * Created by 18710 on 2017/8/24.
 */
public class T33PrintMinNumber {

    public static void main(String[] args) {
        int[] data = {3, 5, 1, 4, 2};
        System.out.println(printMinNumber(data));

        int[] data2 = {3, 32, 321};
        System.out.println(printMinNumber(data2));

        int[] data3 = {3, 323, 32123};
        System.out.println(printMinNumber(data3));

        int[] data4 = {1, 11, 111};
        System.out.println(printMinNumber(data4));

        int[] data5 = {321};
        System.out.println(printMinNumber(data5));
    }

    /**
     * 自定义排序比较器，实现算法说明的排序原理
     */
    public static class MCompator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            if (o1 == null || o2 == null) {
                throw new IllegalArgumentException("Arg should be not null");
            }
            String str1 = o1 + o2;
            String str2 = o2 + o1;
            return str1.compareTo(str2);
        }
    }

    /**
     * 快速排序算法
     * @param array 待排序数组
     * @param left 排序的起始位置
     * @param right 排序的结束位置
     * @param mCompator 自定义的比较器
     */
    public static void qSort(String[] array, int left, int right, Comparator<String> mCompator) {
        if (left >= right) {
            return;
        }
        int start = left; // 暂存起始节点的位置
        int end = right; // 暂存结束节点的位置
        // 快速排序思想
        String temp = array[left];
        while (left < right) {
            while (left < right && mCompator.compare(array[right], temp) >= 0) {
                right--;
            }
            array[left] = array[right];
            while (left < right && mCompator.compare(array[left], temp) <= 0) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = temp;
        // 递归排序左右两部分
        qSort(array, start, left - 1, mCompator);
        qSort(array, left + 1, end, mCompator);
    }

    /**
     * 题目：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
     * 打印能拼接出的所有数字中最小的一个。
     * @param array 输入的正整数数组
     * @return 输出结果
     */
    public static String printMinNumber(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        // 将正整数数组转换为字符串数组
        String[] arr = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            arr[i] = array[i] + "";
        }
        MCompator mCompator = new MCompator(); // 自定义比较规则的比较器
        qSort(arr, 0, arr.length - 1, mCompator); // 快排，时间复杂度为：O(nlogn)
        StringBuffer sb = new StringBuffer();
        for (String str : arr) { // 此时排序好的数组组合就是最小的数字
            sb.append(str);
        }
        return sb.toString();
    }

}
