package com.example.order;

import java.util.Arrays;

public class OrderTest5 {
    public static void main(String[] args) {
        int[] arr = new int[]{30, 3, 79, 40, 55, 33, 66};
        System.out.println("排序前：" + Arrays.toString(arr));
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

    /**
     * 快速排序
     *
     * @param arr
     */
    private static void quickSort(int[] arr, int left, int right) {
        // 首先定义左指针和右指针，以及确定中间那个数
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];
        // 然后开始循环
        while (l < r) {
            // 依次查找左边 >= 中间值 的数；右边 <= 中间值的数
            while (arr[l] < pivot) {
                l++;
            }
            while (arr[r] > pivot) {
                r--;
            }
            // 找到了之后，判断左右指针是否移动过界（肯定不会过界，其实就是判断左右指针是否同时都指向中间的那个值）l是否 大于等于 r
            if (l >= r) {
                break;
            }
            // 如果找到合适的值进行交换，并且l依然在左边，r依然在右边。就交换
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            // 交换完成之后，正常来说会继续重复while循环，但是为了避免重复判断刚才已经交换过的值，所以要移动一下指针
            if (arr[l] == pivot) {  // 这里说明原先右边的值=pivot了，已经换到arr[l]了。就说明现在右边的值就是大于pivot的，就不需要判断了，所以移动指针
                r--;
            }
            if (arr[r] == pivot) {  // 这里同上
                l++;
            }
        }
        // 退出循环后，需要首先判断l是否等于r
        if (l == r) {  // 如果相等，就需要将这两个指针分别移动一下
            l++;
            r--;
        }

        // 如果循环结束，就说明当前pivot左边的值全部小于它，pivot右边的值全部大于它。
        // 此时就需要分别对左边的半部分和右边的半部分进行递归判断了
        if (r > left) {
            quickSort(arr, left, r);
        }
        if (l < right) {
            quickSort(arr, l, right);
        }
    }
}
