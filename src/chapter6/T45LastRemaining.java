package chapter6;

import java.util.LinkedList;
import java.util.List;

/**
 * 面试题45：圆圈中最后剩下的数字
 * 题目：0,1,...,n-1这n个数字排成一个圆圈，从数字0开始每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 * 例如，0,1,2,3,4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2,0,4,1，因此最后剩下的数字是3。
 * 本题就是有名的约瑟夫（Josephuse）环问题。我们介绍两种方法：一种方法是用环形链表模拟圆圈的经典算法，第二种方法是分析每次被删除
 * 的数字的规律并直接计算出圆圈中最后剩下的元素。（基本上面试官要求掌握第一种方法即可，第二种方法对数学基础要求很高）
 *
 * 思路：
 * 1. 经典的解法，用环形链表模拟圆圈：我们可以创建一个总共有n个结点的环形链表，然后每次在这个链表中删除第m个结点。
 * 这种方法每删除一个数字需要m步运算，总共有n个数字，因此总的时间复杂度是O(mn)。同时这种思路还需要一个辅助链表来模拟
 * 圆圈，其空间复杂度是O(n)。
 * 2. 创新的解法：经过一系列数学推到得到每次剩下的数字是f(n,m) = (f(n-1,m) + m) % n （对于n大于1）
 * 时间复杂度是O(n)，空间复杂度是O(1)。
 *
 * Created by 18710 on 2017/8/30.
 */
public class T45LastRemaining {

    public static void main(String[] args) {
        test01();
        System.out.println();
        test02();
    }

    private static void test01() {
        System.out.println(lastRemaining(5, 3)); // 最后余下3
        System.out.println(lastRemaining(5, 2)); // 最后余下2
        System.out.println(lastRemaining(6, 7)); // 最后余下4
        System.out.println(lastRemaining(6, 6)); // 最后余下3
        System.out.println(lastRemaining(0, 0)); // 最后余下-1
    }

    private static void test02() {
        System.out.println(lastRemaining2(5, 3)); // 最后余下3
        System.out.println(lastRemaining2(5, 2)); // 最后余下2
        System.out.println(lastRemaining2(6, 7)); // 最后余下4
        System.out.println(lastRemaining2(6, 6)); // 最后余下3
        System.out.println(lastRemaining2(0, 0)); // 最后余下-1
    }


    /**
     * 每次删除后剩余数组的最后一个元素
     * 每删除一个数字需要m次运算，总共有n个数字，时间复杂度为 O(mn)
     * @param n n个数字
     * @param m 每次删除第m个数字
     * @return 最后的那个数
     */
    public static int lastRemaining(int n, int m) {
        if (n <= 0 || m <= 0) {
//            throw new RuntimeException("输入不符合规范");
            return -1;
        }
        List<Integer> list = new LinkedList<>(); // 链表
        int index = 0; // 链表下标
        for (int i = 0; i < n; i++) { // 向链表中添加元素：1 ~ (n-1)
            list.add(i);
        }
        // 不是最后一个元素
        while (list.size() != 1) {
            index = (index + m - 1) % list.size(); // 只要移动m-1次就可以移动到下一个要删除的元素上
            list.remove(index); // 删除下标对应数据
        }
        return list.get(0);
    }

    /**
     * 创新的解法：经过一系列数学推到得到每次剩下的数字是f(n,m) = (f(n-1,m) + m) % n （对于n大于1）
     * 时间复杂度是 O(n)，空间复杂度是 O(1)
     * 高级解法，不要求
     * @param n n个数字
     * @param m 每次删除第m个数字
     * @return 最后的那个数
     */
    public static int lastRemaining2(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }

}
