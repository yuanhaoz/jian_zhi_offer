package chapter_sort;

/**
 * 二分查找
 * Created by 18710 on 2017/9/3.
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9};
        System.out.println(binarySearch(a, 0, a.length - 1, 2));
        System.out.println(binarySearch(a, 2));
    }

    // 非递归
    public static int binarySearch(int[] arr, int goal) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (right - left) / 2 + left;
            if (arr[mid] == goal) {
                return mid;
            } else if (arr[mid] > goal) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    // 递归
    public static int binarySearch(int[] a, int low, int high, int goal) {
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (a[mid] == goal) {
                return mid;
            } else if (a[mid] < goal) {
                return binarySearch(a, mid + 1, high, goal);
            } else {
                return binarySearch(a, low, mid - 1, goal);
            }
        }
        return -1;
    }

}
