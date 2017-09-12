package chapter_freq;

/**
 * 1 01背包问题
 * 1.1 题目
 * 有N件物品和一个容量为V 的背包。放入第i件物品耗费的费用是Ci，得到的价值是Wi。求解将哪些物品装入背包可使价值总和最大。也即占用背包的空间容量，后文统一称之为“费用(cost)”
 * 1.2 基本思路
 * 这是最基础的背包问题，特点是：每种物品仅有一件，可以选择放或不放。用子问题定义状态：即F [i, v]表示前i件物品恰放入一个容量为v的背包可
 * 以获得的最大价值。则其状态转移方程便是：F [i,v] = max(F [i − 1, v], F [i − 1, v − Ci] + Wi)
 * 这个方程非常重要，基本上所有跟背包相关的问题的方程都是由它衍生 出来的。所以有必要将它详细解释一下：“将前i件物品放入容量为v的背包中”这个子问题，
 * 若只考虑第i件物品的策略（放或不放），那么就可以转化为一个只和前i − 1件物品相关的问题。如果不放第i件物品，那么问题就转化为
 * “前i − 1件物品放入容量为v的背包中”，价值为F [i − 1, v]；如果放第i件物品，那么问题就转化为“前i − 1件物品放入剩下的容量为v − Ci的背包中”，
 * 此时能获得的最大价值就是F [i − 1, v − Ci]再加上通过放入第i件物品获得的价值Wi。伪代码如下：
 * F [0, 0...V ] = 0
 * for i = 1 to N
 * for v = Ci to V
 * F [i, v] = max(F [i − 1, v], F [i − 1, v − Ci] + Wi)
 *
 * Created by yuanhao on 2017/9/11.
 */
public class T4Package1 {

    /**
     * 0-1背包问题：动态规划
     * @param m 背包的最大容量
     * @param n 商品个数
     * @param w 商品重量数组
     * @param p 商品价值数组
     * @return 最大价值
     */
    public static int[][] backPackage(int m, int n, int[] w, int[] p) {
        // c[i][v]表示前i件物品恰放入一个重量为m的背包可以获得的最大价值
        int[][] c = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) { // 重量为0
            c[i][0] = 0;
        }
        for (int i = 0; i < m + 1; i++) { // 前0件
            c[0][i] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                //当物品为i件重量为j时，如果第i件的重量(w[i-1])小于重量j时，c[i][j]为下列两种情况之一：
                //(1)物品i不放入背包中，所以c[i][j]为c[i-1][j]的值
                //(2)物品i放入背包中，则背包剩余重量为j-w[i-1],所以c[i][j]为c[i-1][j-w[i-1]]的值加上当前物品i的价值
                if (w[i - 1] <= j) {
                    if (c[i - 1][j] < (c[i - 1][j - w[i - 1]] + p[i - 1])) {
                        c[i][j] = c[i - 1][j - w[i - 1]] + p[i - 1];
                    } else {
                        c[i][j] = c[i - 1][j];
                    }
                } else {
                    c[i][j] = c[i - 1][j];
                }
            }
        }
        return c;
    }

    public static void main(String[] args) {
        int m = 10;
        int n = 3;
        int w[] = {3,4,5};
        int p[] = {4,5,6};
        int[][] c = backPackage(m, n, w, p);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.print(c[i][j] + "\t");
                if (j == m) {
                    System.out.println();
                }
            }
        }
    }

}
