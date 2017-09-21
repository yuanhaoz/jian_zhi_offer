package chapter_freq;

/**
 * 1 01背包问题          http://blog.csdn.net/ls5718/article/details/52227908
 * 1.1 题目
 * 有N件物品和一个容量为V 的背包。放入第i件物品耗费的费用是Ci，得到的价值是Wi。求解将哪些物品装入背包可使价值总和最大。
 * 也即占用背包的空间容量，后文统一称之为“费用(cost)”
 *
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

    public static void main(String[] args) {
        int m = 10;
        int n = 3;
        int w[] = {3,4,5};
        int p[] = {4,5,6};
        System.out.println("二维数组法：");
        backPackage(m, n, w, p);
        System.out.println("一维数组法：");
        backPackageNeedNotFull(m, n, w, p);
        backPackageMustFull(m, n, w, p);

        int m1 = 12;
        int n1 = 5;
        int w1[] = {3,5,2,6,4};
        int p1[] = {4,4,3,5,3};
        System.out.println("二维数组法：");
        backPackage(m1, n1, w1, p1);
        System.out.println("一维数组法：");
        backPackageNeedNotFull(m1, n1, w1, p1);
        backPackageFullPackage(m1, n1, w1, p1);

        int m2 = 12;
        int n2 = 5;
        int w2[] = {3,4,6,2,5};
        int p2[] = {6,8,7,5,9};
        System.out.println("一维数组法：");
        backPackageMustFull(m2, n2, w2, p2);
    }

    /**
     * 0-1背包问题：二维数组法
     * 背包问题主要是指一个给定容量的背包、若干具有一定价值和重量的物品，如何选择物品放入背包使物品的价值最大。
     * 其中又分01背包和无限背包，这里主要讨论01背包，即每个物品最多放一个。而无限背包可以转化为01背包。
     * 先说一下算法的主要思想，利用动态规划来解决。每次遍历到的第i个物品，根据w[i]和v[i]来确定是否需要将该物品放入背包中。
     * 即对于给定的n个物品，设v[i]、w[i]分别为第i个物品的价值和重量，C为背包的容量。
     * 再令v[i][j]表示在前i个物品中能够装入容量为j的背包中的最大价值。则我们有下面的结果：
     * （1）v[i][0]=v[0][j]=0;
     * （2）v[i][j]=v[i-1][j]   当w[i]>j
     * （3）v[i][j]=max{v[i-1][j],v[i-1][j-w[i]]+v[i]}  当j>=w[i]
     * @param m 背包的最大容量
     * @param n 商品个数
     * @param weights 商品重量数组
     * @param values 商品价值数组
     */
    public static void backPackage(int m, int n, int[] weights, int[] values) {
        // c[i][v]表示前i件物品恰放入一个重量为m的背包可以获得的最大价值
        int[][] c = new int[n + 1][m + 1];
        int[][] path = new int[n + 1][m + 1]; // 保存方向
        for (int i = 0; i < n + 1; i++) { // 重量为0
            c[i][0] = 0;
        }
        for (int i = 0; i < m + 1; i++) { // 前0件
            c[0][i] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                //第i件物品的重量为(w[i-1])
                //当物品为i件的重量(w[i-1])大于重量j时，则直接为上一中情况
                //当物品为i件重量为j时，如果第i件的重量(w[i-1])小于重量j时，c[i][j]为下列两种情况之一：
                //(1)物品i不放入背包中，所以c[i][j]为c[i-1][j]的值
                //(2)物品i放入背包中，则背包剩余重量为j-w[i-1],所以c[i][j]为c[i-1][j-w[i-1]]的值加上当前物品i的价值v[i-1]
                if (weights[i - 1] <= j) {
                    if (c[i - 1][j] < (c[i - 1][j - weights[i - 1]] + values[i - 1])) {
                        c[i][j] = c[i - 1][j - weights[i - 1]] + values[i - 1];
                        path[i][j] = 1;
                    } else {
                        c[i][j] = c[i - 1][j];
                    }
                } else {
                    c[i][j] = c[i - 1][j];
                }
            }
        }

        // 打印数组
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.print(c[i][j] + "\t");
                if (j == m) {
                    System.out.println();
                }
            }
        }

        // 打印出最大条件的组合情况
        int i = path.length - 1; // n个商品
        int j = path[0].length - 1; // 重量为j
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.println("第" + i + "个物品，总量为：" + weights[i - 1] + "，价值为：" + values[i - 1]);
                j -= weights[i - 1];
            }
            i--;
        }
    }

    /**
     * 0-1背包问题：一维数组法（无须装满）
     * 以上方法的时间和空间复杂度均为O(N*V)，其中时间复杂度基本已经不能再优化了，但空间复杂度却可以优化到O(V)。
     先考虑上面讲的基本思路如何实现，肯定是有一个主循环i=1..N，每次算出来二维数组f[i][0..V]的所有值。那么，如果只用一个数组f[0..V]，能不能保证第i次循环结束后f[v]中表示的就是我们定义的状态f[i][v]呢？f[i][v]是由f[i-1][v]和f[i-1][v-c[i]]两个子问题递推而来，能否保证在推f[i][v]时（也即在第i次主循环中推f[v]时）能够得到f[i-1][v]和f[i-1][v-c[i]]的值呢？事实上，这要求在每次主循环中我们以v=V..0的顺序推f[v]，这样才能保证推f[v]时f[v-c[i]]保存的是状态f[i-1][v-c[i]]的值。伪代码如下：
     for i=1..N
     for v=V..0
     f[v]=max{f[v],f[v-c[i]]+w[i]};
     其中的f[v]=max{f[v],f[v-c[i]]}一句恰就相当于我们的转移方程f[i][v]=max{f[i-1][v],f[i-1][v-c[i]]}，因为现在的f[v-c[i]]就相当于原来的f[i-1][v-c[i]]。如果将v的循环顺序从上面的逆序改成顺序的话，那么则成了f[i][v]由f[i][v-c[i]]推知，与本题意不符，但它却是另一个重要的背包问题P02最简捷的解决方案，故学习只用一维数组解01背包问题是十分必要的。
     我们看到的求最优解的背包问题题目中，事实上有两种不太相同的问法。有的题目要求“恰好装满背包”时的最优解，有的题目则并没有要求必须把背包装满。一种区别这两种问法的实现方法是在初始化的时候有所不同。
     如果是第一种问法，要求恰好装满背包，那么在初始化时除了f[0]为0其它f[1..V]均设为-∞，这样就可以保证最终得到的f[N]是一种恰好装满背包的最优解。
     如果并没有要求必须把背包装满，而是只希望价格尽量大，初始化时应该将f[0..V]全部设为0。
     为什么呢？可以这样理解：初始化的f数组事实上就是在没有任何物品可以放入背包时的合法状态。如果要求背包恰好装满，那么此时只有容量为0的背包可能被价值为0的nothing“恰好装满”，其它容量的背包均没有合法的解，属于未定义的状态，它们的值就都应该是-∞了。如果背包并非必须被装满，那么任何容量的背包都有一个合法解“什么都不装”，这个解的价值为0，所以初始时状态的值也就全部为0了。
     * @param m 背包的最大容量
     * @param n 商品个数
     * @param weights 商品重量数组
     * @param values 商品价值数组
     */
    public static void backPackageNeedNotFull(int m, int n, int[] weights, int[] values) {
        int[] f = new int[m + 1]; // 保存重量数组
        /**
         * 初始化为0，与必须装满的区别
         */
        for (int i = 0; i < f.length; i++) {
            f[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            /**
             * 从后往前遍历，与完全背包的区别
             */
            for (int j = f.length - 1; j >= weights[i]; j--) {
                f[j] = Math.max(f[j], f[j - weights[i]] + values[i]);
            }
        }
        for (int i = 0; i < f.length; i++) {
            System.out.print(f[i] + " ");
        }
        System.out.println();
        System.out.println("最大价值为：" + f[f.length - 1]);
    }

    /**
     * 0-1背包问题：一维数组法（必须装满）
     * 背包的容量必须刚好满足设定值。初始化不同：
     * 初始化：f[0] = 0, f[1-...-m] = 无穷小 （必须装满）
     * 初始化：f[0-...-m] = 0 （无须装满）
     * @param m 背包的最大容量
     * @param n 商品个数
     * @param weights 商品重量数组
     * @param values 商品价值数组
     */
    public static void backPackageMustFull(int m, int n, int[] weights, int[] values) {
        int[] f = new int[m + 1]; // 保存重量数组
        /**
         * 初始化为无穷小，与无需装满的区别
         */
        for (int i = 1; i < f.length; i++) {
            f[i] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < n; i++) {
            for (int j = f.length - 1; j >= weights[i]; j--) { // 当前重量j大于i的物品重量
                f[j] = Math.max(f[j], f[j - weights[i]] + values[i]);
            }
        }
        for (int i = 0; i < f.length; i++) {
            System.out.print(f[i] + " ");
        }
        System.out.println();
        System.out.println("最大价值为：" + f[f.length - 1]);
    }

    /**
     * 完全背包：一维数组法（无须装满）
     有N种物品和一个容量为V的背包，每种物品都有无限件可用。
     第i种物品的费用是c[i]，价值是w[i]。
     求解将哪些物品装入背包可使这些物品的费用总和不超过背包容量，且价值总和最大。
     但我们有更优的O(VN)的算法。
     O(VN)的算法
     这个算法使用一维数组，先看伪代码：
     for i=1..N
     for v=0..V
     f[v]=max{f[v],f[v-cost]+weight}
     你会发现，这个伪代码与P01的伪代码只有v的循环次序不同而已。
     * @param m 背包的最大容量
     * @param n 商品个数
     * @param weights 商品重量数组
     * @param values 商品价值数组
     */
    public static void backPackageFullPackage(int m, int n, int[] weights, int[] values) {
        int[] f = new int[m + 1]; // 保存重量数组
        // 初始化为0，与必须装满的区别
        for (int i = 0; i < f.length; i++) {
            f[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            /**
             * 从前往后遍历，与0-1背包的区别
             */
            for (int j = weights[i]; j < f.length; j++) {
                f[j] = Math.max(f[j], f[j - weights[i]] + values[i]);
            }
        }
        for (int i = 0; i < f.length; i++) {
            System.out.print(f[i] + " ");
        }
        System.out.println();
        System.out.println("最大价值为：" + f[f.length - 1]);
    }

}
