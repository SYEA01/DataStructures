package com.example.order;

import java.util.Arrays;

public class OrderTest3 {
    public static void main(String[] args) {
        int[] arr = {8, 0, 2, 3, 9, 5};

        System.out.println("排序前：" + Arrays.toString(arr));
//        bubbleSort(arr);
//        selectSort(arr);
//        insertSort(arr);
//        shellSort(arr);
//        int[] temp = new int[arr.length];
//        mergeSort(arr, 0, arr.length - 1, temp);
        radixSort(arr);
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


    /**
     * 希尔排序
     *
     * @param arr
     */
    private static void shellSort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int insertValue = arr[i];
                int insertIndex = i - gap;
                while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                    arr[insertIndex + gap] = arr[insertIndex];
                    insertIndex -= gap;
                }
                if (insertIndex != i - gap) {
                    arr[insertIndex + gap] = insertValue;
                }
            }
        }
    }

    /**
     * 归并排序
     *
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;

        while (i <= mid && j <= right) {
            if (arr[i] >= arr[j]) {
                temp[t++] = arr[j++];
            } else {
                temp[t++] = arr[i++];
            }
        }

        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }

        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft++] = temp[t++];
        }
    }

    public static void radixSort(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();

        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCount = new int[10];
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            // 给桶里放
            for (int j = 0; j < arr.length; j++) {
                int element = arr[j] / n % 10;
                bucket[element][bucketElementCount[element]] = arr[j];
                bucketElementCount[element]++;
            }
            // 从桶里取
            int index = 0;
            // 先遍历这10个桶
            for (int k = 0; k < bucket.length; k++) {
                // 然后判断哪个桶里有数据
                if (bucketElementCount[k] > 0) {
                    for (int l = 0; l < bucketElementCount[k]; l++) {
                        arr[index++] = bucket[k][l];
                    }
                }
            }
            System.out.println("第" + (i + 1) + "轮：" + Arrays.toString(arr));
        }
    }


}
