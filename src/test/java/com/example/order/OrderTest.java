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
            int val = arr[i];
            int index = i - 1;
            while (index >= 0 && val < arr[index]) {
                arr[index + 1] = arr[index];
                index--;
            }

            if (index != i - 1) {
                arr[index + 1] = val;
            }

            System.out.println("第" + i + "次排序：" + Arrays.toString(arr));
        }
    }


    public static void shellSort(int[] arr) {
        // 设置初始增量为数组的一半，并逐渐缩小
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 开始插入排序
            for (int i = gap; i < arr.length; i++) {
                int val = arr[i];  // 当前待插入元素
                int preIndex = i - gap;  // 待插入元素前一个 gap 间隔位置的索引
                // 循环找可以插入的位置
                while (preIndex >= 0 && val < arr[preIndex]) {
                    arr[preIndex + gap] = arr[preIndex];  // 将有序列表的值往后移
                    preIndex -= gap;  // 向前移动索引，继续查找
                }
                // // 若 preIndex 发生变化，插入 val 到 preIndex + gap 位置
                if (preIndex != i - gap) {
                    arr[preIndex + gap] = val;
                }
            }
        }
    }
}
