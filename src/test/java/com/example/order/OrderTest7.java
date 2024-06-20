package com.example.order;

import java.util.Arrays;

public class OrderTest7 {
    public static void main(String[] args) {
        int[] arr = new int[]{79, 40, 55, 30, 3, 33, 66};
        System.out.println("排序前：" + Arrays.toString(arr));
//        shellSort(arr);
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    /**
     * 冒泡排序：两两比较
     *
     * @param arr
     */
    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int temp;
            boolean flag = false;
            for (int j = i; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (flag) {
                flag = false;
            } else {
                break;  // 此时代表没有进入内层for循环，也就是没有交换位置。就意味着后一个元素总比前一个元素大，就说明此时列表已经是有序的了，就可以直接退出循环
            }
            System.out.println("这是第" + (i + 1) + "次排序：" + Arrays.toString(arr));
        }
    }

    /**
     * 选择排序：选择一个小的数字排到前面
     *
     * @param arr
     */
    private static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minValue = arr[i];
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (minValue > arr[j]) {
                    minValue = arr[j];
                    minIndex = j;
                }
            }
            System.out.println();
            System.out.println("i = " + i);
            System.out.println("minValue = " + minValue);
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = minValue;
            }
            System.out.println("这是第" + (i + 1) + "次排序：" + Arrays.toString(arr));
        }
    }

    /**
     * 插入排序：从后面的无序列表中取出元素插入到前面的有序列表中
     *
     * @param arr 30, 30, 79, 40, 55, 33, 66
     */
    private static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int currValue = arr[i];
            int prefixIndex = i - 1;
            while (prefixIndex >= 0 && currValue < arr[prefixIndex]) {
                arr[prefixIndex + 1] = arr[prefixIndex];
                prefixIndex--;
            }
            // 此时退出while循环，代表已经找到待插入的位置了

            if (prefixIndex != i - 1) {
                arr[prefixIndex + 1] = currValue;
            }
            System.out.println("currValue = " + currValue);
            System.out.println("这是第" + i + "次排序：" + Arrays.toString(arr));
        }
    }

    /**
     * 希尔排序（缩小增量排序） [ 增强版插入排序 ]
     *
     * @param arr 30, 30, 79, 40, 55, 33, 66
     */
    private static void shellSort(int[] arr) {
        int length = arr.length;
        System.out.println("length = " + length);
        // gap代表增量
        for (int gap = length / 2; gap > 0; gap /= 2) {
            System.out.println("gap = " + gap);
            for (int i = gap; i < length; i++) {
                int currValue = arr[i];
                int prefixIndex = i - gap;
                while (prefixIndex >= 0 && currValue < arr[prefixIndex]) {
                    arr[prefixIndex + gap] = arr[prefixIndex];
                    prefixIndex -= gap;
                }
                if (prefixIndex != i - gap) {
                    arr[prefixIndex + gap] = currValue;
                }
            }
            System.out.println(Arrays.toString(arr));
            System.out.println("================================");
        }
    }

    /**
     * 快速排序
     *
     * @param arr 1，2，3，4，3
     */
    private static void quickSort(int[] arr, int left, int right) {
        // 定义指针
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];

        while (l < r) {
            // 找到左边大于中间值的数，右边小于中间值的数
            while (arr[l] < pivot) {
                l++;
            }
            while (arr[r] > pivot) {
                r--;
            }
            // 如果两个指针都指向中间，退出while循环
            if (l == r) {
                break;
            }
            // 交换元素
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            // 1，2，3，4，3
            if (arr[l] == pivot) {
                r--;
            }
            if (arr[r] == pivot) {
                l++;
            }
        }

        // 当左边的值都小于pivot，右边的值都大于pivot
        if (l == r) {
            l++;
            r--;
        }

        // 递归
        if (left < r) {
            quickSort(arr, left, r);
        }
        if (l < right) {
            quickSort(arr, l, right);
        }

    }


}
