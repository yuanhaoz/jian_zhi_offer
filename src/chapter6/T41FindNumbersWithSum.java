package chapter6;

/**
 * 面试题41：和为s的两个数字 VS 和为s的连续正数序列
 * 题目一：输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，输出任意一对即可
 * 思路：1.两遍遍历数组判断；2.两个指针分别从两端开始查找
 *
 * 题目二：输入一个正数s，打印出所有和为s的连续正数序列（至少含有两个数）。例如输入15，由于1+2+3+4+5=4+5+6=7+8=15，所以结果
 * 打印出3个连续序列1-5，4-6，7-8
 * 思路：两个指针初始化为相邻
 *
 * 本题考点：
 * 考查知识迁移能力。应聘者面对第二个问题的时候，能不能把解决第一个问题的思路应用到新的题目上，是面试官考查知识迁移能力的重要指标。
 *
 * Created by 18710 on 2017/8/28.
 */
public class T41FindNumbersWithSum {

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 11, 15};
        int sum = 15;
        findNumberWithSum(arr, sum);
        System.out.println("------------------------");
        findContinuousSequence(9);
        System.out.println("------------------------");
        findContinuousSequence(15);
    }

    /**
     * 面试题41：和为s的两个数字 VS 和为s的连续正数序列
     * 两个指针从数组两端开始遍历
     * @param arr 数组
     * @param sum 和为sum
     * @return 满足条件的两个元素的下标
     */
    public static int[] findNumberWithSum(int[] arr, int sum) {
        int[] result = new int[2];
        if (arr == null || arr.length == 0) {
            return null;
        }
        int start = 0; // 从两端开始遍历
        int end = arr.length - 1;
        while (start < end) { // 循环条件，两个指针不相遇
            int temp = arr[start] + arr[end];
            if (temp == sum) {
                result[0] = arr[start];
                result[1] = arr[end];
                break;
            } else if (temp < sum) { // 值的和小于sum，右移动左指针使得和变大
                start++;
            } else { // 值的和大于sum，左移动右指针使得和变小
                end--;
            }
        }
        System.out.println(result[0] + " " + result[1]);
        return result;
    }

    /**
     * 和等于sum的连续子串
     * @param sum
     */
    public static void findContinuousSequence(int sum) {
        int[] result = new int[2];
        if (sum < 3) {
            return ;
        }
        int first = 1; // 两个相邻的指针
        int second = 2;
        int count = first + second;
        while (first < second && second <= (1 + sum) / 2) { // 循环退出条件
            if (count == sum) { // 和等于sum就打印
                print(first, second);
                System.out.println();
                second++;
                count += second;
            } else if (count < sum) { // 值小于sum，第二个指针后移一位
                second++;
                count += second;
            } else { // 值大于sum，第一个指针后移一位
                count -= first;
                first++;
            }
        }
    }

    /**
     * 打印数组信息
     * @param first 第一个指针
     * @param second 第二个指针
     */
    private static void print(int first, int second) {
        for (int i = first; i <= second; i++) { // 打印数组子串
            System.out.print(i + " ");
        }
    }

}
