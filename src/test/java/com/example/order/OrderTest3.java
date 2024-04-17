package com.example.order;

import java.util.Arrays;

public class OrderTest3 {
    public static void main(String[] args) {
        int[] arr = {8, 0, 2, 3, 9, 5};

        System.out.println("排序前：" + Arrays.toString(arr));
//        bubbleSort(arr);
//        selectSort(arr);
        insertSort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    /**
     * 手写冒泡排序
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                System.out.println("第" + (i + 1) + "次排序：" + Arrays.toString(arr));
            }
            System.out.println();
            if (Boolean.FALSE == flag) {
                break;
            } else {
                flag = false;
            }
        }
    }

    /**
     * 选择排序
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
            System.out.println("第" + (i + 1) + "次排序：" + Arrays.toString(arr));
        }
    }

    /**
     * 插入排序  0 2 4 6 3
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int val = arr[i];
            int preIndex = i - 1;
            while (preIndex >= 0 && val < arr[preIndex]) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            if (preIndex != i - 1) {
                arr[preIndex + 1] = val;
            }
        }
    }
}
