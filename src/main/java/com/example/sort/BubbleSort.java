package com.example.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {0, 5, 3, 7, 2};
        System.out.println("排序前的数组 = " + Arrays.toString(arr));


        bubbleSort(arr);

        System.out.println("排序后的数组 = " + Arrays.toString(arr));


    }

    private static void bubbleSort(int[] arr) {
        // 冒泡排序
        int temp;
        boolean flag = false;  // 标识变量（标识是否进行过交换）
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            if (Boolean.FALSE == flag) {  // 一次交换都没有发生
                break;
            } else {
                flag = false;  // 重置flag，进行下一次交换
            }

//            System.out.println("第" + (i + 1) + "次排序：" + Arrays.toString(arr));
        }
    }

}
