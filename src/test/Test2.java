package test;

import java.util.Scanner;

/**
 * @author yuanhao
 * @date 2018/4/18 19:16
 */
public class Test2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        printProbability(n, 6);
    }

    /**
     * 基于递归求解
     * @param number 骰子个数（n）
     * @param max 骰子的最大值（6）
     */
    public static void printProbability(int number, int max) {
        if (max < 1 || max < 1) {
            return;
        }
        int maxSum = number * max; // 骰子最大和 6n，骰子最小和 n
        int[] probability = new int[maxSum - number + 1]; // 保存骰子所有和情况的数组，长度是 6n-n+1
        probability(number, probability, max); // 得到所有情况和的次数
        double countAll = 1;
        for (int i = 0; i < number; i++) { // n个骰子出现的点数情况总和
            countAll *= max;
        }
        // 打印出每种和出现的概率
//        for (int i = number; i <= maxSum; i++) {
//            double ratio = probability[i - number] / countAll;
//            System.out.printf("%-8.4f", ratio);
//        }
//        System.out.println();

        System.out.print("[");
        for (int i = number; i <= maxSum ; i++) {
            double ratio = probability[i - number] / countAll;
            System.out.print("[" + i + ", ");
            System.out.printf("%.5f", ratio);
            if (i == maxSum) {
                System.out.print("]");
            } else {
                System.out.print("], ");
            }
        }
        System.out.print("]");

    }

    /**
     * 递归求解骰子和的所有情况：第n位上的数字为1~max，加上之前的所有和
     * @param number 骰子个数
     * @param probability 不同骰子出现次数的计数数组
     * @param max 骰子的最大值
     */
    public static void probability(int number, int[] probability, int max) {
        for (int i = 1; i <= max; i++) { // 其实第一个位置的值可以为1~max
            probability(number, number, i, probability, max);
        }
    }

    /**
     * 递归求解骰子和的所有情况：第n位上的数字为1~max，加上之前的所有和
     * 剩余一个元素时结束，此时和加1
     * @param original 骰子总个数
     * @param current 当前骰子个数
     * @param sum 当前的和
     * @param probability 骰子和情况统计的数组
     * @param max 骰子最大值
     */
    public static void probability(int original, int current, int sum, int[] probability, int max) {
        if (current == 1) { // 最后一个骰子，将和对应的数组值加1，注意下标要减去number，因为数组和为number对应数组的第一个元素
            probability[sum - original]++;
        } else {
            for (int i = 1; i <= max; i++) { // 下一个元素的值可能是1~max中的一个值，每次骰子数减1并且骰子剩余个数减1
                probability(original, current - 1, sum + i, probability, max);
            }
        }
    }

}
