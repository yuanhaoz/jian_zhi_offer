package chapter5;

/**
 * 面试题32：从1到n整数中1出现的次数
 * 题目：输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数。例如输入12，从1到12这些整数中包含1的数字有1,10,11和12，1一共出现了5次。
 *
 * 思路：
 * 1. 不考虑时间效率的解法，靠它先拿offer有点难
 * 如果在面试的时候碰到这个问题，应聘者大多数能想到最直观的方法，也就是累加1到n中每个整数1出现的次数。我们可以每次通过对10求余数
 * 再判断整数的个位数字是不是1。如果这个数字大于10，除以10之后再判断个位数字是不是1。
 *
 * Created by 18710 on 2017/8/23.
 */
public class T32NumberOf1Between1AndN {

    public static void main(String[] args) {
        System.out.println(numberOf1Between1AndN(12));
        System.out.println(numberOf1Between1AndN2(12));
    }

    /**
     * 我们可以每次通过对10求余数
     * 再判断整数的个位数字是不是1。如果这个数字大于10，除以10之后再判断个位数字是不是1。
     * @param n 输入参数
     * @return 1的出现次数
     */
    public static int numberOf1Between1AndN(int n) {
        if (n < 0) {
            return 0;
        }
        int count = 0; // 计数器统计1到n中1的次数
        for (int i = 1; i <= n; i++) { // 从1到n开始遍历
            int k = i;
            while (k > 0) { // 循环条件，每次除以10
                int yushu = k % 10;
                if (yushu == 1) { // 余数为1次数加1
                    count++;
                }
                k = k / 10;
            }
        }
        return count;
    }

    /**
     * @param n 输入参数
     * @return 1的出现次数
     */
    public static int numberOf1Between1AndN2(int n) {
        if (n <= 0) {
            return 0;
        }
        String temp = n + ""; // 将数字转换为字符串
        int[] numbers = new int[temp.length()]; // 将数组存在字符数组中
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = temp.charAt(i) - '0';
        }
        return numberOf1(numbers, 0); // 递归遍历
    }

    public static int numberOf1(int[] numbers, int index) {
        if (numbers == null || index > numbers.length || numbers.length < 0) {
            return 0;
        }
        int first = numbers[index]; // 待处理的第一个数
        int length = numbers.length - index; // 要处理的数字位数
        if (first == 0 && length == 1) { // 如果只有一位且这一位是0返回0
            return 0;
        }
        if (first > 0 && length == 1) { // 如果只有一位且这一位不是0返回1
            return 1;
        }
        // 假设numbers是21345，numberFirstDigit是数字10000-19999的第一位中1的数目
        int numberFirstDigit = 0;
        if (first > 1) { // 如果最高位大于1，如21345，在[1346,21345]中最高位1只在[10000, 19999]中出现，出现的次数是10^4
            numberFirstDigit = powerBase10(length - 1);
        } else if (first == 1) { // 如果最高位是1，如12345，在[2346,12345]中，最高位1出现的只在[10000,12345]中，共计2345+1个
            numberFirstDigit = aoti(numbers, index + 1) + 1;
        }
        // numberOtherDigits是[1346, 21345]中，除了第一位之外（不看21345中的第一位2）的数位中1的数目，排列组合
        int numberOtherDigits = first * (length - 1) * powerBase10(length - 2);
        // numberRecursive 是1-1234中1的数目，递归调用本函数求解
        int numberRecursive = numberOf1(numbers, index + 1);
        return numberFirstDigit + numberOtherDigits + numberRecursive;
    }

    /**
     * 求10的n次方
     * @param n n次方
     * @return
     */
    public static int powerBase10(int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result *= 10;
        }
        return result;
    }

    /**
     * 将数字数组转换成数值，如{1, 2, 3, 4, 5}，i = 2，结果是345
     * @param numbers 数组
     * @param index 开始下标
     * @return
     */
    public static int aoti(int[] numbers, int index) {
        int result = 0;
        for (int i = index; i < numbers.length; i++) {
            result = result * 10 + numbers[index];
        }
        return result;
    }

}
