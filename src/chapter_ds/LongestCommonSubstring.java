package chapter_ds;

/**
 * 最长公共子串
 * 动态规划：求的最长子串长度和最后一个相同字符的下标即可
 * 参考链接：http://blog.csdn.net/hackbuteer1/article/details/6686931
 *
 *
 * Created by 18710 on 2017/8/24.
 */
public class LongestCommonSubstring {

    public static void main(String[] args) {
        char[] x = {'A', 'B', 'C', 'D',};
        char[] y = { 'C', 'A', 'B', 'E'};
        getLongestCommonSubstring(x, y);
    }

    /**
     * 动态规划：状态为目前的最长子串长度
     * lcs[i][j] = 0; if i == 0 || j == 0 || x[i]!=y[j]
     * lcs[i][j] = lcs[i-1][j-1] + 1; if x[i]=y[j]
     * @param x 第一个字符串
     * @param y 第二个字符串
     * @return
     */
    public static void getLongestCommonSubstring(char[] x, char[] y) {
        if (x == null || y == null || x.length == 0 || y.length == 0) {
            return ;
        }
        int max = 0; // 最长公共子串的长度
        int lastX = 0; // 第一个字符串 最长公共子串最后一个字符的数组下标
        // 长度为原来的长度加1，因为第一行和第一列的值都是空，
        // 这样动态规划的时候省去判断第一行然后i-0小于0的情况
        int[][] lcs = new int[x.length + 1][y.length + 1]; // 保存最长子序列的长度

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y.length; j++) {
                if (x[i] == y[j]) {
                    lcs[i + 1][j + 1] = lcs[i][j] + 1; // 相等公共子序列长度加1
                } else {
                    lcs[i + 1][j + 1] = 0;  // 左边的元素值较大
                }
                if (lcs[i + 1][j + 1] > max) { // 更新最长子串的长度和两个子串对应的下标
                    max = lcs[i + 1][j + 1];
                    lastX = i;
                }
            }
        }
        System.out.println("最长子串长度为：" + max + ",下标为：" + lastX);
        StringBuffer sb = new StringBuffer(); // 保存最长公共子串
        while (max-- > 0) {
            sb.append(x[lastX--]);
        }
        System.out.println(sb.reverse().toString()); // 逆序打印
    }

}
