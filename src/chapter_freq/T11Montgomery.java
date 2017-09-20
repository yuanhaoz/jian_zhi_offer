package chapter_freq;

import java.util.Scanner;

/**
 * 快速幂模算法（蒙格马利快速幂模算法）
 * 当我们计算A^B%C的时候，最便捷的方法就是调用Math函数中的pow方法，但是有时A的B次方数字过大，
 * 即使是双精度的double也会溢出，这个时候为了得到AB%C的结果，我们会选择使用快速幂取模算法，简单快速的得到我们想要的结果。
 * 为了防止数字溢出并且降低复杂度，我们需要用到下面的公式:
 * a^b mod c = (a mod c)^b mod c
 * 这个公式的意思就是：积的取余等于取余的积的取余。
 * 很容易看出来这个公式是具有传递性的，这样我们可以通过不断的取余让a越来越小，防止出现溢出的情况。
 * 理论上，有了这个公式我们就可以写代码了，通过不断的对a进行取模保证结果不会溢出，
 * 这确实能计算出较大次方的幂的模，但是这种方法的复杂度仍旧是O(N)，并不快速。
 * 为了更快速的计算出幂的模，我们还要依赖下面这个公式：
 * a^b mod c = (a^2)^(b/2) mod c , b为偶数
 * a^b mod c = ((a^2)^(b/2)·a) mod c , b为奇数
 * 这个公式很简单，原理就是不断的用a的平方来代替b，将b替换为原来的一半。
 * 因为我们通过第一个公式知道了一个数的模的相同次方的模相同（这句话说的有点绕，就是公式一的意思）。
 * 那么我们用a*a%c的结果来代替a效果是一样的。
 * 所以根据上述的公式，我们得到复杂度O（logN）这样的计算快速幂的方法：
 * Created by 18710 on 2017/9/20.
 */
public class T11Montgomery {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt(), b = in.nextInt(), c = in.nextInt();
        int res = 1;
        a %= c;
        for (; b > 0; b /= 2) { // 每次除以2
            if ((b & 1) == 1) { // 判断是不是奇数
                res = (res * a) % c;
            }
            a = (a * a) % c; // 每次对c求余
        }
        System.out.println(res);
    }

}
