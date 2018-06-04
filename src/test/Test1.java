package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author yuanhao
 * @date 2018/4/18 19:16
 */
public class Test1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        printProbability2(n, 6);
    }

    /**
     * 基于递归求解
     * @param number 骰子个数（n）
     * @param max 骰子的最大值（6）
     */
    public static void printProbability2(int number, int max) {
        if (number < 1 || max < 1) {
            return;
        }
        int[][] probabilities = new int[2][max * number + 1]; // 初始数组大小为2*（6n+1）
        // 数组初始化
        for (int i = 1; i < max * number + 1; i++) {
            probabilities[0][i] = 0;
            probabilities[1][i] = 0;
        }
        // 标记当前要是用的是第0个数组还是第1个数组
        int flag = 0;
        // 抛出一个骰子时出现的各种情况
        for (int i = 1; i <= max; i++) {
            probabilities[flag][i] = 1; // 第一个数组记录当前和的出现次数
        }
        // 抛出其它骰子
        for (int k = 2; k <= number; k++) {
            // 如果抛出了k个骰子，那么和为[0, k-1]出现的次数为0
            for (int i = 0; i < k; i++) {
                probabilities[1 - flag][i] = 0; // 另外一个数组记录前n-1次每次的和
            }
            // 抛出k个骰子，所有和的可能
            for (int i = k; i <= max * k; i++) {
                probabilities[1 - flag][i] = 0;
                // 每个骰子出现的所有可能的点数
                for (int j = 1; j <= i && j <= max; j++) {
                    // 统计出和为i的点数出现的次数
                    probabilities[1 - flag][i] += probabilities[flag][i - j];
                }
            }
            flag = 1 - flag;
        }
        // 计算总共出现的可能情况
        double total = 1;
        for (int i = 0; i < number; i++) {
            total *= max;
        }
        // 打印出每种和出现的概率
        int maxSum = number * max;
        System.out.print("[");
        for (int i = number; i <= maxSum ; i++) {
            double ratio = probabilities[flag][i] / total;
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
     * 基于递归求解
     * @param number 骰子个数（n）
     * @param max 骰子的最大值（6）
     */
    public static void printProbability2(Long number, int max) {
        if (number < 1 || max < 1) {
            return;
        }
        List<Long> probabilities1 = new ArrayList<>();
        List<Long> probabilities2 = new ArrayList<>();

//        int[][] probabilities = new int[2][max * number + 1]; // 初始数组大小为2*（6n+1）
        // 数组初始化
        for (int i = 1; i < max * number + 1; i++) {
            probabilities1.set(i, 0L);
            probabilities2.set(i, 0L);
        }
        // 标记当前要是用的是第0个数组还是第1个数组
        int flag = 0;
        // 抛出一个骰子时出现的各种情况
        for (int i = 1; i <= max; i++) {
//            probabilities[flag][i] = 1; // 第一个数组记录当前和的出现次数
            if (flag == 0) {
                probabilities1.set(i, 1L);
            } else {
                probabilities2.set(i, 1L);
            }
        }
        // 抛出其它骰子
        for (int k = 2; k <= number; k++) {
            // 如果抛出了k个骰子，那么和为[0, k-1]出现的次数为0
            for (int i = 0; i < k; i++) {
//                probabilities[1 - flag][i] = 0; // 另外一个数组记录前n-1次每次的和
                if (flag == 0) {
                    probabilities2.set(i, 0L);
                } else {
                    probabilities1.set(i, 0L);
                }
            }
            // 抛出k个骰子，所有和的可能
            for (int i = k; i <= max * k; i++) {
//                probabilities[1 - flag][i] = 0;
                if (flag == 0) {
                    probabilities2.set(i, 0L);
                } else {
                    probabilities1.set(i, 0L);
                }
                // 每个骰子出现的所有可能的点数
                for (int j = 1; j <= i && j <= max; j++) {
                    // 统计出和为i的点数出现的次数
//                    probabilities[1 - flag][i] += probabilities[flag][i - j];
                    if (flag == 0) {
                        probabilities2.set(i, probabilities2.get(i) + probabilities1.get(i - j));
                    } else {
                        probabilities1.set(i, probabilities1.get(i) + probabilities2.get(i - j));
                    }
                }
            }
            flag = 1 - flag;
        }
        // 计算总共出现的可能情况
        double total = 1;
        for (int i = 0; i < number; i++) {
            total *= max;
        }
        // 打印出每种和出现的概率
        long maxSum = number * max;
        System.out.print("[");
        for (int i = Integer.parseInt(number+""); i <= maxSum ; i++) {
            double ratio = 0;
            if (flag == 0) {
                ratio = probabilities1.get(i)/total;
            } else {
                ratio = probabilities2.get(i)/total;
            }
//            double ratio = probabilities[flag][i] / total;
//            double ratio = probabilities[flag][i] / total;
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

}
