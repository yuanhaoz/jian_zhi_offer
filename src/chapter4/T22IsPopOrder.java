package chapter4;

import java.util.Stack;

/**
 * 面试题22：栈的压入、弹出序列
 * 题目：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出序列。
 *
 * 思路：
 * 1. 如果下一个弹出的数字刚好是栈顶数字，那么直接弹出。如果下一个弹出的数字不在栈顶，我们把压栈序列中还没有入栈的数字压入辅助栈，直到
 * 把下一个需要弹出的数字压入栈顶为止。如果所有的数字都压入栈了仍然没有找到下一个弹出的数字，那么该序列不可能是一个弹出序列。
 * Created by 18710 on 2017/8/15.
 */
public class T22IsPopOrder {

    /**
     * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断二个序列是否为该栈的弹出顺序。
     * 假设压入栈的所有数字均不相等。例如序列1 、2、3 、4、5 是某栈压栈序列，
     * 序列4、5、3、2、1是该压栈序列对应的一个弹出序列，
     * 但4、3、5、1、2就不可能是该压棋序列的弹出序列。
     * 【与书本的的方法不同】
     *
     * @param push 入栈序列
     * @param pop  出栈序列
     * @return true：出栈序列是入栈序列的一个弹出顺序
     */
    public static boolean isPopOrder(int[] push, int[] pop){
        if (push == null || pop == null || push.length == 0 || pop.length == 0 || push.length != pop.length) {
            return false;
        }
        int pushIndex = 0; // 需要压入的下标
        int popIndex = 0; // 需要弹出的下标
        Stack<Integer> stack = new Stack<>(); // 辅助栈
        while(popIndex < pop.length) { // 弹出序列没有结束
            // 栈初始为空、栈顶元素不等于需要弹出的元素时：不断压入元素入栈
            while(pushIndex < push.length && (stack.isEmpty() || stack.peek() != pop[popIndex])) { // 栈顶元素不是不要弹出的值
                stack.push(push[pushIndex]);
                pushIndex++;
            }
            // 相等的时候弹出栈并且判断下一个元素。如果还是不相等说明错误
            if (stack.peek() == pop[popIndex]) {
                stack.pop();
                popIndex++;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {4, 5, 3, 2, 1};
        int[] pop1 = {4, 3, 5, 1, 2};
        System.out.println(isPopOrder(push, pop));
        System.out.println(isPopOrder(push, pop1));
    }


}
