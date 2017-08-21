package chapter5;

/**
 * 面试题31：连续子数组的最大和
 * 题目：输入一个整形数组，数组里有正数也有负数。数组中一个或连续的多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度是O(n)。
 *
 * 思路：
 * 1. 举例分析数组规律
 * 用一个数字记录加到当前元素的和a，另外一个记录最大连续子串的和b。当a加上下一个元素小于0，则使a为下一个元素，从头开始计算，b始终为最大值
 * 2. 应用动态规划法
 * 如果函数f(i)表示以第i个数字结尾的子数组的最大和，那么我们需要求出max[f(i)]，其中0<=i<n。
 * f(i)=pData[i] , if i=0或者f(i-1)<=0
 * f(i)=f(i-1)+pData[i], if i != 0并且f(i-1)>0
 * 这个公式的意义是：当以第i-1个数字结尾的子数组中所有数字的和小于0时，如果把这个负数与第i个数累加，得到的结果比第i个数字本身还要小，
 * 所以这种情况下以第i个数字结尾的子数组就是第i个数字本身。如果以第i-1个数字结尾的子数组中所有数字的和大于0，与第i个数字累加就得到以
 * 第i个数字结尾的子数组中所有数字的和。
 *
 * Created by 18710 on 2017/8/21.
 */
public class T31FindGreatestSumOfSubArray {

    public static void main(String[] args) {
        int[] arr = {1,-2,3,10,-4,7,2,-5};
        System.out.println(findGreatestSumOfSubArray(arr));
        System.out.println(findGreatestSumOfSubArray2(arr));
    }

    /**
     * 1. 举例分析数组规律     时间复杂度：O(n)，空间复杂度为：O(1)
     * @param arr
     * @return
     */
    public static int findGreatestSumOfSubArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int curSum = 0; // 当前位置的子序列的最大和
        int biggest = 0; // 整体的子序列的最大和
        for (int i = 0; i < arr.length; i++) {
            if (curSum < 0) { // 如果和小于0，那么加上当前节点的值没有当前节点值大，所有直接替换为当前节点的值
                curSum = arr[i];
            } else { // 加上当前节点的值
                curSum += arr[i];
            }
            biggest = Math.max(curSum, biggest); // 比较得到整体最大子序列的值
        }
        return biggest;
    }

    /**
     * 2. 动态规划   时间复杂度：O(n)，空间复杂度为：O(n)
     * @param arr
     * @return
     */
    public static int findGreatestSumOfSubArray2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[] sum = new int[arr.length];
        sum[0] = arr[0];
        int biggest = arr[0]; // 整体的子序列的最大和
        for (int i = 1; i < arr.length; i++) {
            if (sum[i - 1] < 0) { // 如果和小于0，那么加上当前节点的值没有当前节点值大，所有直接替换为当前节点的值
                sum[i] = arr[i];
            } else { // 加上当前节点的值
                sum[i] = sum[i - 1] + arr[i]; // 状态转移方程
            }
            biggest = Math.max(sum[i], biggest);
        }
        return biggest;
    }

}
