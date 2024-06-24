package com.example.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 3, 3, 3, 5, 6, 7, 8, 9};
        List<Integer> list = binarySearch2(arr, 0, arr.length - 1, 4);
        System.out.println("list = " + list);
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


    public static List<Integer> binarySearch2(int[] arr, int left, int right, int target) {
        List<Integer> list = new ArrayList<>();
        if (left > right) {
            return list;
        }

        int mid = (left + right) / 2;
        if (arr[mid] < target) {  // 向右递归
            binarySearch2(arr, mid + 1, right, target);
        } else if (arr[mid] > target) { // 向左递归
            binarySearch2(arr, left, mid - 1, target);
        } else {
            list.add(mid);
            // 向左扫描
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != target) {
                    break;
                }
                list.add(temp);
                temp--;
            }

            // 向右扫描
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != target) {
                    break;
                }
                list.add(temp);
                temp++;
            }
        }
        return list;
    }

}
