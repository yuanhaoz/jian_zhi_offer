package chapter_freq;

/**
 * 任意2n个整数，从其中选出n个整数，使得选出的n个整数和同剩下的n个整数之和的差最小。
 *
 * 这题其实难度相当大，看了很多朋友的答案，都想的太简单了。排序啊，首尾取啊，不妨多几个测试用例想下，都是有错的。

 编程之美上的题，《数组分割》：

 假设数组A[1..2N]所有元素的和是SUM。
 模仿动态规划解0-1背包问题的策略，令S(k, i)表示前k个元素中任意i个元素的和的集合。
 显然：
 S(k, 1) = {A[i] | 1<= i <= k}
 S(k, k) = {A[1]+A[2]+…+A[k]}
 S(k, i) = S(k-1, i) U {A[k] + x | x属于S(k-1, i-1) }
 按照这个递推公式来计算，最后找出集合S(2N, N)中与SUM最接近的那个和，这便是答案。



 有一个没有排序，元素个数为2N的正整数数组。要求把它分割为元素个数为N的两个数组，并使两个子数组的和最接近。
 思路书上都有。
 这个if判断，if (j >= A[k] && flag[i - 1][j - A[k]])，j >= A[k]条件是为了让flag数组的第二维不越界。
 参考了这个地址：
 http://www.cppblog.com/baby-fly/archive/2009/09/24/92392.html



 *
 * Created by yuanhao on 2017/9/9.
 */
public class T3ArraySplit {

    public   static   void  main(String[] args) {
        int  A[] = {  1 ,  2 ,  3 ,  5 ,  7 ,  8 ,  9  };
        // int A[] = { 1, 5, 7, 8, 9, 6, 3, 11, 20, 17 };
        func(A);
    }

    static   void  func( int  A[]) {
        int  i;
        int  j;

        int  n2 = A.length;
        int  n = n2 /  2 ;
        int  sum =  0 ;
        for  (i =  0 ; i < A.length; i++) {
            sum += A[i];
        }

        /**
         * flag[i][j]:任意i个数组元素之和是j,则flag[i][j]为true
         */
        boolean  flag[][] =  new   boolean [A.length +  1 ][sum /  2  +  1 ];
        for  (i =  0 ; i < A.length; i++)
            for  (j =  0 ; j < sum /  2  +  1 ; j++)
                flag[i][j] = false ;

        flag[0 ][ 0 ] =  true ;

        for  ( int  k =  0 ; k < n2; k++) {
            for  (i = k > n ? n : k; i >=  1 ; i--) {
                // 两层外循环是遍历集合S(k,i)
                for  (j =  0 ; j <= sum /  2 ; j++) {
                    if  (j >= A[k] && flag[i -  1 ][j - A[k]])
                        flag[i][j] = true ;
                }
            }
        }
        for  (i = sum /  2 ; i >=  0 ; i--) {
            if  (flag[n][i]) {
                System.out.println("sum is "  + sum);
                System.out.println("sum/2 is "  + sum /  2 );
                System.out.println("i is "  + i);
                System.out.println("minimum delta is "  + Math.abs( 2  * i - sum));
                break ;
            }
        }
    }

}
