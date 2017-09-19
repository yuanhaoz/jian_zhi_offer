package chapter_freq;

/**
 * LeetCode算法题：JAVA实现整数反转reverse integer
 Reverse digits of an integer.

 Example1: x = 123, return 321
 Example2: x = -123, return -321

 1、首先我想到的是最笨的方法
 思路：将整数转为数组，通过数组的角标来实现反转，再将数组最终转为int类型（数组–>String–>Integer）

 2、模十取余
 不断模10取得最低位，再不断乘10相加得到最终的反转结果

 * Created by 18710 on 2017/9/19.
 */
public class T10ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverseInteger(123));
        System.out.println(reverseInteger(-123));
        System.out.println(reverseInteger(200));
        System.out.println(reverseInteger(-200));
        System.out.println(reverseInteger(0));
        System.out.println(reverseInteger(1234567899)); // 整数溢出
    }

    /**
     * 模十取余：不断模10取得最低位，再不断乘10相加得到最终的反转结果（考虑溢出情况）
     * @param n
     * @return
     */
    public static int reverseInteger(int n) {
        int result = 0;
        while (n != 0) {
            int temp = result * 10 + n % 10;
            n = n / 10;
            if (temp / 10 != result) { // 不相等说明溢出，返回0输出
                result = 0;
                break;
            }
            result = temp;
        }
        return result;
    }

}
