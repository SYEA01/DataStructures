package com.example.sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 6, 2, 7, 1, 4};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后的结果: " + Arrays.toString(arr));
    }

    /**
     * @param arr   待排序的数组
     * @param left  最左边的索引
     * @param right 最右边的索引
     */
    public static void quickSort(int[] arr, int left, int right) {
        int l = left;  // 左下标
        int r = right;  // 右下标
        int pivot = arr[(left + right) / 2];  // 中间的那个数

        // 只要左下标 < 右下标 ，就循环
        while (l < r) {
            // 在pivot 的左边一直找，直到找到一个大于等于pivot的值，退出
            while (arr[l] < pivot) {
                l += 1;
            }
            // 在pivot 的右边一直找，知道找到一个小于等于pivot的值，退出
            while (arr[r] > pivot) {
                r -= 1;
            }
            // 如果l>=r 成立，说明pivot 左右两边的值已经按照 左边全部比pivot小，右边全部比pivot大 了
            if (l >= r) {
                break;
            }
            // 此时左边的值比右边的值大，交换
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            // 如果交换完之后，发现 arr[l] == pivot , r--
            // 这里就表示：如果在交换前 arr[r] = pivot 了，那么交换后arr[l] == pivot，此时arr[r]的值就是原来arr[l]的值，就代表右边r所代表的值已经交换过了，为了避免后面再次比较pivot与arr[r] 的值。
            if (arr[l] == pivot) {
                r--;
            }
            // 这里就表示：如果在交换前 arr[l] = pivot 了，那么交换后arr[r] == pivot，此时arr[l]的值就是原来arr[r]的值
            if (arr[r] == pivot) {
                l++;
            }
        }

        // 如果l == r，必须l++，r--
        if (l == r) {
            l++;
            r--;
        }
        // 向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }
        // 向右递归
        if (right > l) {
            quickSort(arr, l, right);
        }

    }
}
