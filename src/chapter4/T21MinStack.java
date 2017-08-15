package chapter4;

import java.util.Stack;

/**
 * 面试题21：包含min函数的栈
 * 题目：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数。
 * 在该栈中，调用min, push, pop的时间复杂度都是O(1)。
 *
 * 思路：
 * 1. 一种思路是在栈里添加一个成员变量存放最小的元素。每次压入一个新元素进栈的时候，如果该元素比当前最小的元素还小，那就更新最小元素。但是有一个问题是
 * 如果当前最小的元素被弹出栈了，如何得到下一个最小的元素呢？仅仅添加一个成员变量存放最小元素是不够的，也就是说当最小元素被弹出栈的时候，我们希望能够得
 * 到次小元素。因此，考虑使用把每次的最小元素保存起来放到另外一个辅助栈里。
 *
 * Created by 18710 on 2017/8/15.
 */
public class T21MinStack {

    /**
     * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数。
     * 在该栈中，调用min, push, pop的时间复杂度都是O(1)。
     * @param <T>
     */
    public static class StackWithMin<T extends Comparable<T>> {
        // 数据栈，用于存放插入的数据
        private Stack<T> dataStack;
        // 最小数位置栈，存放数据栈中最小的数的位置
        private Stack<T> minStack;
        // 构造函数
        public StackWithMin() {
            this.dataStack = new Stack<>();
            this.minStack = new Stack<>();
        }

        /**
         * 出栈方法
         * @return 栈顶元素
         */
        public T pop() {
            if (dataStack.isEmpty()) {
                throw new RuntimeException("The stack is already empty");
            }
            minStack.pop();
            return dataStack.pop();
        }

        /**
         * 元素入栈
         * @param t 入栈的元素
         */
        public void push(T t) {
            dataStack.push(t);
            if (minStack.isEmpty() || minStack.peek().compareTo(t) > 0) {
                minStack.push(t);
            } else {
                minStack.push(minStack.peek());
            }
        }

        /**
         * 获取数据栈的最小元素
         * @return 栈中的最小元素
         */
        public T min() {
            // 如果最小数位置栈已经为空，则抛出异常
            if (minStack.isEmpty()) {
                throw new RuntimeException("No element in stack.");
            }
            // 获取数据栈中的最小元素，并且返回结果
            return minStack.peek();
        }



    }



}
