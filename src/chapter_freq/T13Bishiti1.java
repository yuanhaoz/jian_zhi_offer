package chapter_freq;

import java.util.Scanner;

/**
 * 小Q的数学老师给了小Q一个整数N，问小Q能否将W分解为两个整数X和Y相乘，并且满足X为奇数，Y为偶数，即能否找到奇数X和偶数Y满足X*Y=N。小Q被这个问题难住了，希望能你来帮助他计算。
 * 输入描述：输入的第一行包含一个正整数 t(1<=t<=1000)，表示测试样例数。
 * 接下来的t行，每行一个正整数 N(2<=N<=2^63)，表示给出的N。保证 N 不是2的幂次。
 * 输出描述：如果能找到这样的 X,Y，则依次输出X,Y，如果有多解输出Y最小的那组解，以空格分割，否则输出“No”。
 *
 * 例如：输入
 * 2
 * 10
 * 5
 * 输出
 * 5 2
 * No
 *
 * @author yuanhao
 * @date 2018/4/9 19:37
 */
public class T13Bishiti1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        Long[] input = new Long[t];
        for (int i = 0; i < t; i++) {
            input[i] = scanner.nextLong();
        }

        for (int i = 0; i < t; i++) {
            if (input[i] % 2 != 0) {
                System.out.println("No");
            } else {
                long x = input[i];
                long y = 1;
                while (x % 2 == 0) {
                    x = x / 2;
                    y = y * 2;
                }
                System.out.println(x + " " + y);
            }
        }

    }

}
