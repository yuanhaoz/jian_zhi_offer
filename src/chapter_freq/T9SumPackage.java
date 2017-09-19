package chapter_freq;

import java.util.LinkedList;

/**
 * 问题：
 输入两个整数 n 和 m，从数列1，2，3.......n 中 随意取几个数,使其和等于 m ,要求将其中所有的可能组合列出来.
 分析：
 由该题可知是典型的背包问题，根据该数是否加入进行递归运算。
 解法：采用0-1背包的思想，使用递归方法：
 　　当选择n时，就用剩下的n-1填满 m-n;
 　　当不选择n时，就用剩下的n-1填满m；
 　注意的是，当m=n时，即找到了符合条件的解。
 * Created by 18710 on 2017/9/19.
 */
public class T9SumPackage {

    public static void main(String[] args) {
        int m = 8;
        int n = 6;
        backPackage(m, n);
        System.out.println(count); // 4 : [2,6] [1,2,5] [1,3,4] [3,5]
    }

    private static LinkedList<Integer> list = new LinkedList<>();
    private static int count = 0;

    public static void backPackage(int sum, int n) {
        if (sum <= 0 || n <= 0) {
            return;
        }
        if (sum == n) { // 找到满足条件的情况
//            for (int i = 0; i < list.size(); i++) {
//                System.out.print(list.get(i) + " ");
//            }
//            System.out.println();
            count++;
        }
        list.add(n);
        backPackage(sum - n, n - 1); // 如果放入n时，则从剩余n - 1个数中填充sum - n
        list.pop();
        backPackage(sum, n - 1); // 如果不放入n，从n - 1个数中填充sum
    }

}
