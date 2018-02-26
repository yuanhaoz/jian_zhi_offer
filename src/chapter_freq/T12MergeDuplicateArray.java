package chapter_freq;

import java.util.Set;
import java.util.TreeSet;

/**
 * 合并两个存在重复元素的有序数组，并使得合并之后的数组也保持有序且无重复元素
 * @author yuanhao
 * @date 2018/1/24 20:38
 */
public class T12MergeDuplicateArray {

    public static void main(String[] args) {
        // 测试案例1：数组1和2为空数组
        int[] arr1 = {};
        int[] arr2 = {};
        int[] res = merge(arr1, arr2);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();

        // 测试案例2：数组1为空数组
        int[] arr3 = {};
        int[] arr4 = {2, 4, 6};
        res = merge(arr3, arr4);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();

        // 测试案例3：数组2为空数组
        int[] arr5 = {2, 4, 6};
        int[] arr6 = {};
        res = merge(arr5, arr6);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();

        // 测试案例4：无重复元素
        int[] arr7 = {1, 3, 5};
        int[] arr8 = {2, 4, 6};
        res = merge(arr7, arr8);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();

        // 测试案例5：无重复元素
        int[] arr9 = {1, 1, 2, 3, 4, 4};
        int[] arr10 = {1, 2, 2, 4, 6, 6};
        res = merge(arr9, arr10);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }

    /**
     * 合并两个存在重复元素的有序数组
     */
    public static int[] merge(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null || (arr1.length == 0 && arr2.length == 0)) {
            return arr1;
        }
        if(arr1 == null || arr1.length == 0) {
            return removeDup(arr2);   // 数组1为空，返回无重复元素的排序数组2
        }
        if(arr2 == null || arr2.length == 0) {
            return removeDup(arr1);  // 数组2为空，返回无重复元素的排序数组1
        }

        int[] result = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int k = 0; // 新数组下标

        while(i < arr1.length && j < arr2.length) {
            if(arr1[i] < arr2[j]) {
                if(k > 0 && result[k - 1] == arr1[i]) {
                    i++;
                } else {
                    result[k++] = arr1[i++];
                }
            } else if (arr1[i] > arr2[j]){
                if(k > 0 && result[k - 1] == arr2[j]) {
                    j++;
                } else {
                    result[k++] = arr2[j++];
                }
            } else { // 两个元素相等时
                if(k > 0 && result[k - 1] == arr1[i]) {
                    i++;
                    j++;
                } else {
                    result[k++] = arr1[i++];
                    j++;
                }
            }
        }

        // 对剩余的数组1的元素
        while(i < arr1.length) {
            if(result[k - 1] == arr1[i]) {
                i++;
            } else {
                result[k++] = arr1[i++];
            }

        }

        // 对剩余的数组2的元素
        while(j < arr2.length) {
            if(result[k - 1] == arr2[j]) {
                j++;
            } else {
                result[k++] = arr2[j++];
            }
        }

        // 数组实际元素个数小于等于两个数组长度之和
        int[] res = new int[k];
        for(int m = 0; m < k; m++) {
            res[m] = result[m];

        }
        return res;
    }

    /**
     * 去除数组中重复的元素
     */
    public static int[] removeDup(int[] arr){
        Set<Integer> set = new TreeSet<>(); // 借助TreeSet
        for(Integer i : arr) {
            set.add(i);
        }
        int[] arrNew = new int[set.size()]; // 无重复元素的排序数组
        int index = 0;
        for(Integer i : set) {
            arrNew[index++] = i;
        }
        return arrNew;
    }
}
