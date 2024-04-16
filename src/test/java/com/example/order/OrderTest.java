package com.example.order;

import java.util.Arrays;

/**
 * 手写排序
 */
public class OrderTest {
    public static void main(String[] args) {
        int[] arr1 = new int[]{30, 3, 79, 40, 55, 33, 66};
        int[] arr2 = new int[]{30, 3, 79, 40, 55, 33, 66};
        int[] arr3 = new int[]{30, 3, 79, 40, 55, 33, 66};
        System.out.println("冒泡排序前 = " + Arrays.toString(arr1));
        bubbleSort(arr1);
        System.out.println("冒泡排序后 = " + Arrays.toString(arr1));
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("选择排序前 = " + Arrays.toString(arr2));
        selectSort(arr2);
        System.out.println("选择排序后 = " + Arrays.toString(arr2));
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("插入排序前 = " + Arrays.toString(arr3));
        insertSort(arr3);
        System.out.println("插入排序后 = " + Arrays.toString(arr3));

    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        boolean flag = false;
        // 因为两两比较，需要n-1次大循环
        for (int i = 0; i < arr.length - 1; i++) {
            // 因为末尾的元素已经排过序了，所以减去已经排过序的元素
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 如果前一个元素大，交换位置
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("第" + (i + 1) + "次排序：" + Arrays.toString(arr));
            if (Boolean.FALSE == flag) {  // 如果没有交换过位置，证明已经有序了，就退出
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
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    index = j;
                }
            }
            if (index != i) {
                arr[index] = arr[i];
                arr[i] = min;
            }
            System.out.println("第" + (i + 1) + "次排序：" + Arrays.toString(arr));
        }
    }


    /**
     * 插入排序
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
            System.out.println("第" + i + "次排序：" + Arrays.toString(arr));
        }
    }
}
