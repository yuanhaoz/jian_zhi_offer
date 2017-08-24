package chapter_ds;

/**
 * 最长公共子序列
 * 参考链接：http://blog.csdn.net/biangren/article/details/8038605
 * Created by 18710 on 2017/8/24.
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        char[] x = {'A', 'B', 'C', 'B', 'D', 'A', 'B'};
        char[] y = { 'B', 'D', 'C', 'A', 'B', 'A'};
        int[][] direction = getLongestCommonSubsequence(x, y);
        getLongestCommonSubsequence(direction, x, x.length - 1, y.length - 1);
    }

    /**
     * 动态规划：状态为目前的最长子序列长度
     * lcs[i][j] = 0; if i == 0 || j == 0
     * lcs[i][j] = lcs[i-1][j-1] + 1; if x[i]=y[j]
     * lcs[i][j] = lcs[i][j-1]; if x[i]!=y[j] && lcs[i][j-1] > lcs[i-1][j]
     * lcs[i][j] = lcs[i-1][j]; if x[i]!=y[j] && lcs[i][j-1] < lcs[i-1][j]
     * 具体流程参考 img文件夹下的 LongestCommonSubsequence.img
     * @param x 第一个字符串
     * @param y 第二个字符串
     * @return 最长子序列的遍历方向
     */
    public static int[][] getLongestCommonSubsequence(char[] x, char[] y) {
        if (x == null || y == null || x.length == 0 || y.length == 0) {
            return null;
        }

        // 长度为原来的长度加1，因为第一行和第一列的值都是空，这样动态规划的时候省去判断第一行然后i-0小于0的情况
        int[][] lcs = new int[x.length + 1][y.length + 1]; // 保存最长子序列的长度
        int[][] direction = new int[x.length + 1][y.length + 1]; // 保存搜索方向

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y.length; j++) {
                if (x[i] == y[j]) {
                    lcs[i + 1][j + 1] = lcs[i][j] + 1; // 相等公共子序列长度加1
                    direction[i + 1][j + 1] = 1; // 1表示左上角对角线移动
                } else if (lcs[i][j + 1] >= lcs[i + 1][j]) { /** 注意条件是大于等于*/
                    lcs[i + 1][j + 1] = lcs[i][j + 1]; // 上边的元素值较大
                    direction[i + 1][j + 1] = 0; // 0表示上移动
                } else {
                    lcs[i + 1][j + 1] = lcs[i + 1][j];  // 左边的元素值较大
                    direction[i + 1][j + 1] = -1; // -1表示左移动
                }
            }
        }
//        for (int i = 0; i < lcs.length; i++) {
//            for (int j = 0; j < lcs[0].length; j++) {
//                System.out.print(lcs[i][j] + " ");
//            }
//            System.out.println();
//        }
//        for (int i = 0; i < direction.length; i++) {
//            for (int j = 0; j < direction[0].length; j++) {
//                System.out.print(direction[i][j] + " ");
//            }
//            System.out.println();
//        }
        return direction;
    }

    /**
     *根据最长子序列的方向打印子序列
     * @param direction 方向数组
     * @param x 第一个或者第二个字符串
     * @param i 横坐标
     * @param j 纵坐标
     */
    public static void getLongestCommonSubsequence (int[][] direction, char[] x, int i, int j) {
        if (i < 0 || j < 0) { // 第一行为空
            return ;
        }
        if (direction[i + 1][j + 1] == 1) { // 1表示左上角
            getLongestCommonSubsequence(direction, x, i - 1, j - 1);
            System.out.print(x[i] + " ");
        } else if (direction[i + 1][j + 1] == 0) { // 0表示上移动
            getLongestCommonSubsequence(direction, x, i - 1, j);
        } else if (direction[i + 1][j + 1] == -1){ // -1表示左移动
            getLongestCommonSubsequence(direction, x, i, j - 1);
        }
    }

}
