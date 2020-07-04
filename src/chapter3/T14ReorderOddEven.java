package chapter3;

import java.util.Arrays;

/**
 * 面试题14：调整数组顺序使奇数位于偶数前面
 * 题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 * 思路：
 * 1.如果不考虑时间复杂度，最简单的思路应该是从头扫描这个数组，没碰到一个偶数时，拿出这个数字，并把位于这个数字后面的所有数字往前挪动一位。挪完之后在数组的末尾
 * 	  有一个空位，这时把该偶数放到这个空位。由于没碰到一个偶数就需要移动O(n)个数字，因此总的时间复杂度是O(n^2)。
 * 2.维护两个指针，第一个指针初始化时指向数组的第一个数字，它只向后移动；第二个指针初始化时指向数组的最后一个元素，它只向前移动。在两个指针相遇之前，
 *   第一个指针总是位于第二个指针的前面。如果一个指针指向的数字是偶数，并且第二个指针指向的数字是奇数，我们就交换这两个数字。然后这两个指针继续指向下一个奇数或偶数。
 *
 * Created by 18710 on 2017/8/12.
 */
public class T14ReorderOddEven {

    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     * 使得所有奇数位于数组的前半部分，所有偶数位予数组的后半部分。
     * @param arr
     */
    public static void reorderOddEven(int[] arr) {
        if (null == arr || 0 == arr.length) {
            return ;
        }
        int left = 0;
        int right = arr.length - 1;
        while(left < right) {
            while (left < right && condition(arr, left)) {
                left++;
            }
            while (left < right && !condition(arr, right)) {
                right--;
            }
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
    }

    /**
     * 判断奇数还是偶数
     * 当题目要求把能被3整除和不能被3整除的数交换时可以更改这里面的程序，程序解耦
     * 很关键。
     * @param arr 数组
     * @param index 下标
     * @return
     */
    public static boolean condition(int[] arr, int index) {
        // 奇数返回true
        if ((arr[index] & 1) != 0) {
            return true;
        }
        return false; // 偶数返回false
    }

    public static void main(String[] args) {
        int[] arr = {};
        reorderOddEven(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr1 = {1};
        reorderOddEven(arr1);
        System.out.println(Arrays.toString(arr1));
        int[] arr2 = {1,2};
        reorderOddEven(arr2);
        System.out.println(Arrays.toString(arr2));
        int[] arr3 = {1,3,5,2,4,6};
        reorderOddEven(arr3);
        System.out.println(Arrays.toString(arr3));
        int[] arr4 = {2,4,6,1,3,5};
        reorderOddEven(arr4);
        System.out.println(Arrays.toString(arr4));
        int[] arr5 = {1,2,3,4,5,6};
        reorderOddEven(arr5);
        System.out.println(Arrays.toString(arr5));
    }
}
