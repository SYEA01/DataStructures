package com.example.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchTest {
    public static void main(String[] args) {
        int[] arr = {1, 15, 19, 31, 36, 57, 234};
//        List<Integer> result = binarySearch2(arr, 0, arr.length - 1, 15);
//        System.out.println("result = " + result);
//        int i = insertValueSearch(arr, 0, arr.length - 1, 15);
        int i = fibonacciSearch(arr, 19);
        System.out.println("i = " + i);
    }

    /**
     * 二分查找 - 找到一个符合的就返回下标
     *
     * @param arr
     * @param left
     * @param right
     * @param target
     * @return
     */
    public static int binarySearch(int[] arr, int left, int right, int target) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        if (target > arr[mid]) {
            return binarySearch(arr, mid + 1, right, target);
        } else if (target < arr[mid]) {
            return binarySearch(arr, left, mid - 1, target);
        } else {
            return mid;
        }
    }

    /**
     * 二分查找 - 返回所有符合的元素的下标
     *
     * @param arr    数组
     * @param left   左索引
     * @param right  右索引
     * @param target 要查找的数
     * @return
     */
    public static List<Integer> binarySearch2(int[] arr, int left, int right, int target) {
        List<Integer> list = new ArrayList<>();
        int mid = (left + right) / 2;
        while (left <= right) {
            if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                list.add(mid);
                int l = mid - 1;
                while (l > 0 && arr[l] == target) {
                    list.add(l--);
                }
                int r = mid + 1;
                while (r < arr.length && arr[r] == target) {
                    list.add(r++);
                }
                break;
            }
            mid = (left + right) / 2;
        }
        return list;
    }

    public static int insertValueSearch(int[] arr, int left, int right, int target) {
        if (left > right || arr[left] > target || arr[right] < target) {
            return -1;
        }
        int mid = left + (right - left) * (target - arr[left]) / (arr[right] - arr[left]);
        while (left <= right) {
            if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
            mid = left + (right - left) * (target - arr[left]) / (arr[right] - arr[left]);
        }
        return -1;
    }

    /**
     * 构造一个斐波那契数列
     *
     * @return 1, 1, 2, 3, 5, 8, 13, 21, 34
     */
    private static int[] fibonacci() {
        int[] fib = new int[20];
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i < 20; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib;
    }

    public static int fibonacciSearch(int[] arr, int target) {
        int[] f = fibonacci();
        int left = 0;
        int right = arr.length - 1;
        int k = 0;
        int mid = 0;

        while (right > f[k] - 1) {
            k++;
        }

        int[] temp = Arrays.copyOf(arr, f[k]);
        for (int i = right + 1; i < f[k]; i++) {
            temp[i] = arr[right];
        }


        while (left <= right) {
            mid = left + f[k - 1] - 1;
            if (target > temp[mid]) {
                left = mid + 1;
                k -= 2;
            } else if (target < temp[mid]) {
                right = mid - 1;
                k--;
            } else {
                if (mid <= right) {
                    return mid;
                } else {
                    return right;
                }
            }
        }


        return -1;
    }
}
