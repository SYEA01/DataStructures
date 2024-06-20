package com.example.order;

import java.util.Arrays;

public class OrderTest6 {
    public static void main(String[] args) {
        int[] arr = new int[]{30, 3, 79, 40, 55, 33, 66};
        System.out.println("排序前：" + Arrays.toString(arr));
//        shellSort(arr);
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int temp;
            boolean flag = false;
            for (int j = i; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
            System.out.println("第" + (i + 1) + "次排序：" + Arrays.toString(arr));
        }
    }

    /**
     * 选择排序
     *
     * @param arr
     */
    private static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
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
     * 插入排序
     *
     * @param arr 30, 30, 79, 40, 55, 33, 66
     */
    private static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int currData = arr[i];
            int prefixIndex = i - 1;
            while (prefixIndex >= 0 && arr[prefixIndex] > currData) {
                arr[prefixIndex + 1] = arr[prefixIndex];
                prefixIndex--;
            }
            if (prefixIndex != i - 1) {
                arr[prefixIndex + 1] = currData;
            }
            System.out.println("第" + i + "次排序：" + Arrays.toString(arr));
        }
    }

    /**
     * 希尔排序（缩小增量排序）
     *
     * @param arr 30, 30, 79, 40, 55, 33, 66
     */
    private static void shellSort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int currData = arr[i];
                int prefixIndex = i - gap;
                while (prefixIndex >= 0 && currData < arr[prefixIndex]) {
                    arr[prefixIndex + gap] = arr[prefixIndex];
                    prefixIndex -= gap;
                }
                if (prefixIndex != i - gap) {
                    arr[prefixIndex + gap] = currData;
                }
            }

        }
    }

    /**
     * 快速排序
     *
     * @param arr
     */
    private static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int mid = arr[(left + right) / 2];

        while (l < r) {
            while (arr[l] < mid) {
                l++;
            }
            while (arr[r] > mid) {
                r--;
            }
            //
            if (l == r) {
                break;
            }
            // 交换位置
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            // 交换完了之后
            if (arr[l] == mid) {
                r--;
            }
            if (arr[r] == mid) {
                l++;
            }
        }

        if (l == r) {
            l++;
            r--;
        }
        if (left < r) {
            quickSort(arr, left, r);
        }
        if (l < right) {
            quickSort(arr, l, right);
        }

    }


}
