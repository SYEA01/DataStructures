package com.example.search;

/**
 * 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 6, 7, 8, 9};
        int i = binarySearch(arr, 0, arr.length - 1, 4);
        System.out.println("i = " + i);
    }

    /**
     * 二分查找算法
     *
     * @param arr    数组
     * @param left   左边的索引
     * @param right  右边的索引
     * @param target 要查找的目标
     * @return 如果找到就返回下标，如果没有找到就返回-1
     */
    public static int binarySearch(int[] arr, int left, int right, int target) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        if (arr[mid] < target) {  // 向右递归
            return binarySearch(arr, mid + 1, right, target);
        } else if (arr[mid] > target) { // 向左递归
            return binarySearch(arr, left, mid - 1, target);
        } else {
            return mid;
        }
    }
}
