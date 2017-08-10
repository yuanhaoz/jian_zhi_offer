package chapter3;

/**
 * 输入数字n，按照顺序打印出从1最大的n位十进制数。比如输入3，则打印出1/2/3，一直到最大的3位数即999。
 *
 *  这个题目看起来很简单。我们看到这个问题之后，最容易想到的方法是先求出最大的n位数，然后用一个循环从1开始逐个打印。
 *  但是当输入的n很大的时候，我们求最大的n位数是不是用整形或者长整形都会溢出？也就是说我们需要考虑大数的问题。
 *
 *  考虑使用数组存储大数
 *
 * Created by 18710 on 2017/8/10.
 */
public class T12PrintOneToNthDigits {

    public static void main(String[] args) {
        printOneToNthDigits(2);
//		printOneToNthDigits(0);
//		printOneToNthDigits(2);
    }

    /**
     *  输入数字n，按照顺序打印出从1最大的n位十进制数。比如输入3，则打印出1/2/3，一直到最大的3位数即999。
     *  全排列用递归很容易理解，数字的每一位都可能是0-9中的一个数，然后设置下一位。递归结束的条件是我们
     *  已经设置了数字的最后一位。
     * @param n 数字的最大位数
     */
    public static void printOneToNthDigits(int n){
        if (n < 0) {
            return ;
        }
        int[] number = new int[n];
        for (int i = 0; i < 10; i++) { // 每次循环
            number[0] = i;
            printOneToNthDigits2(number, n, 0);
        }
    }

    /**
     * 递归
     * @param number
     * @param n
     * @param index
     */
    public static void printOneToNthDigits2(int[] number, int n, int index){
        if (index == n - 1) {
            print(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[index + 1] = i;
            printOneToNthDigits2(number, n, index + 1);
        }
    }

    /**
     * 打印数组
     * @param number 数组
     */
    public static void print(int[] number) {
        boolean flag = false;
        for (int i = number.length - 1; i >= 0; i--) {
            if (number[i] != 0) {
                flag = true;
            }
            if (flag) {
                System.out.print(number[i]);
            }
        }
        System.out.println();
    }

}
