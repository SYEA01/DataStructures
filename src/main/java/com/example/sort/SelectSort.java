package com.example.sort;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {5, 9, 3, 7, 1,-1,90,123};

        // 选择排序  时间复杂度 O(n^2)
        selectSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 选择排序
     *
     * @param arr
     */
    private static void selectSort(int[] arr) {
        // n-1轮 大的循环
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int index = i;
            // 依次找最小值
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    index = j;
                }
            }

            // 找到了之后，进行交换
            if (index != i) {
                arr[index] = arr[i];
                arr[i] = min;
            }
            System.out.println("第" + (i + 1) + "轮：" + Arrays.toString(arr));
        }
    }
}
