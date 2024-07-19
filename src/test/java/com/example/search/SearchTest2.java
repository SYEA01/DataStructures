package com.example.search;

public class SearchTest2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 6, 8, 9};
        int i = insertValueSearch(arr, 0, arr.length - 1, 3);
        System.out.println("i = " + i);
    }

    /**
     * 二分查找
     *
     * @param arr
     * @param left
     * @param right
     * @param target
     * @return
     */
    public static int binarySearch(int[] arr, int left, int right, int target) {
        int mid = (left + right) / 2;
        while (left <= right) {
            if (target > arr[mid]) {
                left = mid + 1;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
            mid = (left + right) / 2;
        }
        return -1;
    }

    /**
     * 插值查找
     *
     * @param arr
     * @param left
     * @param right
     * @param target
     * @return
     */
    public static int insertValueSearch(int[] arr, int left, int right, int target) {
        int mid = left + (right - left) * (target - arr[left]) / (arr[right] - arr[left]);
        while (left <= right) {
            if (arr[mid] < target) {
                left = mid + 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
            mid = left + (right - left) * (target - arr[left]) / (arr[right] - arr[left]);
        }

        return -1;
    }
}
