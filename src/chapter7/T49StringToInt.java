package chapter7;

/**
 * 面试题49：  把字符串转换成整数，不使用库函数
 *
 * 1. 判断第一个字符是 '+', '-' 还是 数字
 * 2. 计算的过程判断是否超出整数表示范围
 *
 * Created by 18710 on 2017/8/31.
 */
public class T49StringToInt {

    public static void main(String[] args) {
        System.out.println(stringToInt("123"));
        System.out.println(stringToInt("+123"));
        System.out.println(stringToInt("-123"));
//        System.out.println(stringToInt("1a123"));
        System.out.println(stringToInt("+2147483647"));
        System.out.println(stringToInt("-2147483647"));
        System.out.println(stringToInt("+2147483648"));
        System.out.println(stringToInt("-2147483648"));
    }

    /**
     * 题目：实现一个函数stringToInt,实现把字符串转换成整数这个功能，
     * 不能使用atoi或者其他类似的库函数。
     * @param num
     * @return
     */
    public static int stringToInt(String num) {
        if (num == null || num.length() == 0) {
            throw new NumberFormatException(num);
        }
        char first = num.charAt(0); // 第一个字符
        if (first == '-') { // 带-的负数
            return parseString(num, 1, false);
        } else if (first == '+') { // 带+的正数
            return parseString(num, 1, true);
        } else if (isDigit(first)) { // 不带+的正数
            return parseString(num, 0, true);
        } else {
            throw new NumberFormatException(num);
        }
    }

    /**
     * 判断一个字符是否是数字
     * @param ch 字符
     * @return 是否是数字
     */
    public static boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    /**
     * 将字符串转化为数字
     * @param num
     * @param index
     * @param positive
     * @return
     */
    public static int parseString(String num, int index, boolean positive) {
        if (index > num.length()) { // 下标越界
            throw new NumberFormatException(num);
        }
        int result = 0;
        long tmp = 0; // 计算保存数字
        while (index < num.length() && isDigit(num.charAt(index))) { // 下标不越界并且是数字
            tmp = tmp * 10 + num.charAt(index) - '0';
            if (tmp > 0x8000_000L) { // 保证求的值不超出整数的最大绝对值
                throw new NumberFormatException(num);
            }
            index++;
        }
        // 判断结果的正负
        if (positive) {
            if (tmp < 0x8000_000L) {
                result = (int) tmp;
            } else { // 判断是否越界
                throw new NumberFormatException(num);
            }
        } else {
            if (tmp < 0x8000_000L) {
                result = (int) -tmp;
            } else {
                throw new NumberFormatException(num);
            }
        }
        return result;
    }

}
