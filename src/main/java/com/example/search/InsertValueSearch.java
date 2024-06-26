package com.example.search;

/**
 * 插值查找
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 3, 3, 3, 5, 6, 7, 8, 9};
//        int[] arr = new int[100];
//        for (int i = 0; i < 100; i++) {
//            arr[i] = i + 1;
//        }

        int i = insertValueSearch(arr, 0, arr.length - 1, 2);
        System.out.println("i = " + i);


    }

    /**
     * 插值查找算法
     *
     * @param arr    数组
     * @param left   左索引
     * @param right  右索引
     * @param target 待查找的值
     * @return 索引
     */
    public static int insertValueSearch(int[] arr, int left, int right, int target) {
        if (left > right || target < arr[0] || target > arr[arr.length - 1]) {
            return -1;
        }
        int mid = left + (right - left) * (target - arr[left]) / (arr[right] - arr[left]);
        while (left <= right) {
            if (target > arr[mid]) {
                left = mid + 1;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
            mid = left + (right - left) * (target - arr[left]) / (arr[right] - arr[left]);
        }
        return -1;
    }

}
