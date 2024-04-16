package com.example.sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1, -1, 33};
        System.out.println("原始数组 = " + Arrays.toString(arr));
        insertSort(arr);
        System.out.println("排序后数组 = " + Arrays.toString(arr));
    }

    /**
     * 插入排序
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {

        // 从第2个数字开始循环
        for (int i = 1; i < arr.length; i++) {
            //
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.println("第" + i + "次：" + Arrays.toString(arr));
        }
    }
}
