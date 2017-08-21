package chapter5;

/**
 * 面试题29：数组中出现次数超过一半的数字
 * 题目：数组中 有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 *
 * 思路：
 * 1. 解法1：基于Partition函数的O(n)算法
 * 数组中有一个数字出现的次数超过了数组长度的一半。如果把这个数组排序，那么排序之后位于数组中间的数字一定就是那个出现次数
 * 超过数组长度一半的数字。也就是说，这个数字就是中位数，即长度为n的数组中第n/2大的数字。
 *
 * 2. 解法2：根据数组特点找出O(n)的算法
 * 数组中有一个数字出现的次数超过数组长度的一半，也就是说它出现的次数比其他所有数字出现次数的和还要多。
 * 因此我们可以考虑在遍历数组的时候保存两个值：一个是数组中的一个数字，一个是次数。当我们遍历到下一个数字的时候，
 * 如果下一个数字和我们之前保存的数字相同，则次数加1；如果下一个数字和我们之前保存的数字不同，则次数减1。
 * 如果次数为0，我们需要保存下一个数字，并把次数设为1.由于我们要找的数字出现的次数比其他所有数字出现的次数之和还要多，
 * 那么要找的数字肯定是最后一次把次数设为1时对应的数字。
 *
 * Created by 18710 on 2017/8/21.
 */
public class T29MoreThanHalfNum {

    /**
     * 题目：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字
     *
     * @param numbers 输入数组
     * @return 找到的数字
     */
    public static int moreThanHalfNum(int[] numbers){
        if (numbers == null || numbers.length == 0) {
            return 0;
        }
        int result = numbers[0]; // 次数超过一半的数
        int count = 1; // 重复次数
        for (int i = 1; i < numbers.length; i++) {
            if (count == 0) { // 如果次数为0，则重新更新
                result = numbers[i];
            } else if (result != numbers[i]) { // 值不同就相减
                count--;
            } else { // 值相同就加1
                count++;
            }
        }
        // 最后的result可能是出现次数大于数组一半长度的值，统计result的出现次数
        count = 0;
        for (int number : numbers) {
            if (result == number) {
                count++;
            }
        }
        // 如果result的出现次数大于数组长度的一半就返回对应的值
        if (count > numbers.length / 2) {
            return result;
        } else {
            System.out.println("不存在出现次数超过数组一半长度的数");
            return 0;
        }
    }

    public static void main(String[] args) {
        // 存在出现次数超过数组长度一半的数字
        int numbers[] = {1, 2, 3, 2, 2, 2, 5, 4, 2};
//        System.out.println(moreThanHalfNum(numbers));
//        System.out.println(moreThanHalfNum2(numbers));

        // 出现次数超过数组长度一半的数字都出现在数组的前半部分
        int numbers2[] = {2, 2, 2, 2, 2, 1, 3, 4, 5};
//        System.out.println(moreThanHalfNum(numbers2));
//        System.out.println(moreThanHalfNum2(numbers2));

        // 出现次数超过数组长度一半的数字都出现在数组的后半部分
        int numbers3[] = {1, 3, 4, 5, 2, 2, 2, 2, 2};
//        System.out.println(moreThanHalfNum(numbers3));
//        System.out.println(moreThanHalfNum2(numbers3));

        // 只有一个数
        int numbers4[] = {1};
//        System.out.println(moreThanHalfNum(numbers4));
//        System.out.println(moreThanHalfNum2(numbers4));

        // 输入空指针
//        moreThanHalfNum(null);
        // 不存在出现次数超过数组长度一半的数字
        int numbers5[] = {1, 2, 3, 2, 4, 2, 5, 2, 3};
        moreThanHalfNum(numbers5);
        moreThanHalfNum2(numbers5);

    }


    /**
     * 快速排序的partition函数
     * @param arr 待排序数组
     * @param left 左指针
     * @param right 右指针
     * @return
     */
    public static int partition(int[] arr, int left, int right) {
        int result = arr[left];
        if (left > right) {
            return -1;
        }
        while (left < right) {
            while (left < right && arr[right] >= result) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] < result) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = result;
        return left;
    }

    public static int moreThanHalfNum2(int[] numbers) {
        // 判断输入是否合法
        if (numbers == null || numbers.length == 0) {
            throw new RuntimeException("输入不合理");
        }
        int half = numbers.length / 2;
        int start = 0;
        int end = numbers.length - 1;
        int index = partition(numbers, start, end); // 快排一次的位置
        while (index != half) { // 判断是不是中间位置
            if (index > half) {
                end = index - 1;
            } else {
                start = index + 1;
            }
            index = partition(numbers, start, end);
        }

        int count = 0;
        for (int number : numbers) {
            if (numbers[index] == number) {
                count++;
            }
        }
        // 如果result的出现次数大于数组长度的一半就返回对应的值
        if (count > numbers.length / 2) {
            return numbers[index];
        } else {
            System.out.println("不存在出现次数超过数组一半长度的数");
            return 0;
        }
    }

}
