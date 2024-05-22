package com.example.order;

import java.util.Arrays;

public class OrderTest5 {
    public static void main(String[] args) {
        int[] arr = new int[]{30, 3, 79, 40, 55, 33, 66};
        System.out.println("排序前：" + Arrays.toString(arr));
        shellSort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 如果交换位置了，就把它置为true
                    flag = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (flag) {
                // 如果交换了位置
                flag = false;
            } else {
                break;
            }
            System.out.println("第" + (i + 1) + "次循环：" + Arrays.toString(arr));
        }
    }

    /**
     * 选择排序
     *
     * @param arr
     */
    private static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 最小值
            int min = arr[i];
            // 最小索引
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
            System.out.println("第" + (i + 1) + "次循环：" + Arrays.toString(arr));
        }
    }

    /**
     * 插入排序
     *
     * @param arr 30, 30, 79, 40, 55, 33, 66
     */
    private static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertValue = arr[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if (insertIndex != i - 1) {
                arr[insertIndex + 1] = insertValue;
            }
            System.out.println("第" + i + "遍循环：" + Arrays.toString(arr));
        }
    }

    /**
     * 希尔排序（缩小增量排序）
     *
     * @param arr 30, 30, 79, 40, 55, 33, 66
     */
    private static void shellSort(int[] arr) {
        int len = arr.length;
        int count = 0;
        for (int gap = len / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                count++;
                int insertValue = arr[i];
                int insertIndex = i - gap;
                while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                    arr[insertIndex + gap] = arr[insertIndex];
                    insertIndex -= gap;
                }
                if (insertIndex != i - gap) {
                    arr[insertIndex + gap] = insertValue;
                }
                System.out.println("第" + count + "遍循环：" + Arrays.toString(arr));
            }
        }
    }
}
