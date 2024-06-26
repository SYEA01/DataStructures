package com.example.search;

import java.util.ArrayList;
import java.util.List;

public class SearchTest {
    public static void main(String[] args) {
        int[] arr = {1, 15, 15, 15, 15, 19, 31, 36, 57, 234};
        List<Integer> result = binarySearch2(arr, 0, arr.length - 1, 15);
        System.out.println("result = " + result);
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
     * @param arr 数组
     * @param left 左索引
     * @param right 右索引
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
}
