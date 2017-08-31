package chapter6;

/**
 * 面试题46：求1+2+...+n
 * 题目：求1+2+...+n，要求不能使用乘除法，for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 *
 * 思路：（C++思路）
 * 1. 使用类的构造函数
 * 2. 利用虚函数求解
 * 3. 利用函数指针求解
 * 4. 利用模板类型求解
 *
 * Created by 18710 on 2017/8/31.
 */
public class T46Sum {

    public static void main(String[] args) {
        int n = 10;
        int sum = 0;
        sum = plus(sum, n);
        System.out.println(sum);
    }

    /**
     * 递归调用自己，每次n--，求得1+2+...+n
     * @param sum n个数的和
     * @param n 第n个数
     * @return n个数的和
     */
    public static int plus(int sum, int n) {
        boolean is_end = true;
        sum += n;
        is_end = (n > 0) && ((sum = plus(sum, --n)) > 0); // 递归调用
        return sum;
    }

}
