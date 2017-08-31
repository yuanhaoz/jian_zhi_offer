package chapter_freq;

/**
 * java 中平方根(sqrt)算法
 平方根(sqrt, square root)是数学中常见的数学的公式;
 使用程序进行求平方根主要分为两步:
 第一步: while()循环, 控制循环次数及小数的位数, 防止无限循环和出现多位小数;
 第二步: 通过分解平方根, 使用循环, 逐渐减小,接近平方根;
 同理, 其他方根也可以类似扩展, 不过需要注意的是,
 偶数次方根需要确保输入正数;
 奇数次方根需要转换为正数, 确保循环收敛, 再进行结果正负判断;
 * Created by 18710 on 2017/8/30.
 */
public class SqrtAlgorithm {

    public static double sqrt(double c)
    {
        if(c<0) return Double.NaN; //NaN: not a number
        double err = 1e-15; //极小值
        double t = c;
        while (Math.abs(t-c/t) > err*t) //t^2接近c, 防止小数   c=t^2 每次更新t为t和c/t的一半，二分法
            t = (c/t + t)/2.0;
        return t;
    }

    public static double cbrt(double c)
    {
        boolean b = (c>0) ? true : false; //保存c的符号
        c = (c>0) ? c : -c;
        double err = 1e-15;
        double t = c;
        while(Math.abs(t*t-c/t) > err*t)
            t = (c/(t*t)+t)/2.0;
        t = (b) ? t : -t;
        return t;
    }

    public static void main(String[] args)
    {
        double r = sqrt(4.0);
        System.out.println("sqrt(4.0) = " + r);
        double rc = cbrt(-27.0);
        System.out.println("cbrt(9.0) = " + rc);
    }


}
