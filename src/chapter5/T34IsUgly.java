package chapter5;

/**
 * 面试题34：丑数
 * 题目：我们把只包含因子2/3/5的数称作丑数（Ugly Number）。求按从小到大的顺序的第1500个丑数。
 * 例如，6/8都是丑数，但14不是，因为它包含因子7.习惯上我们把1当做第一个丑数。
 *
 * 思路：
 * 1. 逐个判断每个整数是不是丑数的解法，直观但不够高效
 * 所谓一个数m是另一个数n的因子，是指n能被m整除，也就是n%m==0。根据丑数的定义，丑数只能被2/3/5整除。也就是说如果一个数
 * 能被2整除，我们把它连续除以2；如果能被3整除，就连续除以3；如果能被5整除，就连续除以5。如果最后我们得到的是1，那么这个数就是丑数，否则不是。
 *
 * 2. 创建数组保存已经找到的丑数，用空间换时间的解法
 * 我们可以创建一个数组，里面的数字都是排好序的丑数，每一个丑数都是前面的丑数乘以2/3/5得到的。
 * 这种思路的关键在于怎么数组里面的丑数是排好序的。假设数组中已经有若干个丑数排好序后存放在数组中，
 * 并且把已有最大的丑数记做M，我们接下来分析如何生成下一个丑数。该丑数肯定是前面某一个丑数乘以2/3/5
 * 的结果，所以我们首先考虑把已有的每个丑数乘以2。在乘以2的时候，能得到若干个小于或者等于M的结果。
 * 由于是按照顺序生成的，小于或者等于M肯定已经在数组中了，我们不需再次考虑；还会得到若干个大于M的结果，
 * 但我们只需要第一个大于M的结果，因为我们希望丑数是按从小到大的顺序生成的，其他更大的结果以后再说。
 * 我们把得到的第一个乘以2后大于M的结果记为M2。同样，我们把已有的每一个丑数乘以3和5，能得到第一个大于
 * M的结果M3和M5.那么下一个丑数应该是M2、M3、M5中的最小值。
 *
 * Created by 18710 on 2017/8/25.
 */
public class T34IsUgly {

    /**
     * 空间换时间，用一个数组存储丑数
     * @param index 第index个丑数
     * @return
     */
    public static int getUglyNumber(int index) {
        if (index <= 0) {
            return 0;
        }
        int[] uglyNumbers = new int[index]; // 丑数数组
        uglyNumbers[0] = 1; // 第一个丑数为1
        int uglyIndex = 1; // 丑数数组的下标
        int twoIndex = 0, threeIndex = 0, fiveIndex = 0; // 分别指示2、3、5的下标
        while (uglyIndex < index) {
            // 每次循环中求出三个数中最小的那个数
            int min = Math.min(uglyNumbers[twoIndex] * 2, Math.min(uglyNumbers[threeIndex] * 3, uglyNumbers[fiveIndex] * 5)); // 下一个最小的丑数
            uglyNumbers[uglyIndex] = min; // 当前位置元素值为该最小值
            // 判断移动三个因子指针中的哪一个
            while (uglyNumbers[twoIndex] * 2 <= min) { // 更新twoIndex下标，使得其与2的乘积大于此时丑数数组的最大值
                twoIndex++;
            }
            while (uglyNumbers[threeIndex] * 3 <= min) {
                threeIndex++;
            }
            while (uglyNumbers[fiveIndex] * 5 <= min) {
                fiveIndex++;
            }
            uglyIndex++; // 更新丑数数组下标
        }
        return uglyNumbers[index - 1];
    }

    /**
     * 判断一个数是不是丑数
     * @param number 需要判断的数
     * @return
     */
    public static boolean isUgly(int number) {
        if (number < 1) {
            return false;
        }
        if (number == 1) {
            return true;
        }
        while (number % 2 == 0) {
            number = number / 2;
        }
        while (number % 3 == 0) {
            number = number / 3;
        }
        while (number % 5 == 0) {
            number = number / 5;
        }
        if (number == 1) {
            return true;
        }
        return false;
    }

    /**
     * 从0开始遍历到第index个丑数，需要将其中的每个元素都遍历，时间复杂度较大
     * @param index 第index个丑数
     * @return
     */
    public static int getUglyNumber2(int index) {
        int number = 0; // 遍历
        int count = 0;
        while (count < index) {
            number++;
            if (isUgly(number)) {
                count++;
            }
        }
        return number;
    }

    public static void main(String[] args) {
        System.out.println(getUglyNumber(100));
        System.out.println(getUglyNumber2(100));
    }

}
