package chapter3;

/**
 * 面试题11：实现函数  double Power(double base, int exponent)，求base的exponent次方。
 * 不得使用库函数，同时不需要考虑大数问题。
 *
 * 类似于斐波那契数列的解法
 * Created by 18710 on 2017/8/10.
 */
public class T11Power {

    public static void main(String[] args) {
//		System.out.println(0.000000000000000000000000 == 0);
        System.out.println(0.000000000000000000001111 == 0);

        System.out.println(Power(2, 4));
        System.out.println(Power(2, -4));
        System.out.println(Power(2, 0));
        System.out.println(Power(0.00000000000000000000000001, -1));
        System.out.println(Power(0.00000000000000000000000001, 1));
        System.out.println(Power(0.00000000000000000000000001, 0));
        System.out.println(Power(0.00000000000000000000000000, 0));
    }

    public static double Power(double base, int exponent) {
        if (base == 0 && exponent == 0) { // 指数和底数不能同时为0
            throw new RuntimeException("分子分母不能同时为0...");
        }
        if (base == 0) { // 底数为0就返回0
            return 0;
        }
        if (exponent == 0) { // 指数为0就返回1
            return 1;
        }
        int exp = exponent;
        if (exponent < 0) {
            exp = -exponent;
        }
        double result = PowerByRecursion(base, exp); // 求幂次方
        if (exp < 0) { // 指数是负数，要进行求倒数
            return 1 / result;
        }
        return result;
    }

    public static double PowerByRecursion(double base, int exponent) {
        // 指数为0，返回1
        if (exponent == 0) {
            return 1;
        }
        // 指数为1，返回底数
        if (exponent == 1) {
            return base;
        }
        // 递归求一半的值
        double result = PowerByRecursion(base, exponent >> 1);
        // 求最终的值，如果是奇数就还要乘以一次底数
        result *= result;
        if ((exponent & 0x01) == 1) { // 用位与运算符代替了求余运算符（%）来判断一个数是奇数还是偶数。位运算效率比乘除法及求余运算的效率要高很多。
            result *= base;
        }
        return result;
    }

}
