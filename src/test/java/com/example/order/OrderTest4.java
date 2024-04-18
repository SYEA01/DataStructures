package com.example.order;

import java.util.Arrays;

public class OrderTest4 {
    public static void main(String[] args) {
        int[] arr =  {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        System.out.println("排序前: " + Arrays.toString(arr));
        shellSort(arr);

    }

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
            }
            System.out.println((i + 1) + "排序后: " + Arrays.toString(arr));
            if (Boolean.FALSE == flag) {
                break;
            } else {
                flag = false;
            }
        }
    }


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
            System.out.println((i + 1) + "排序后: " + Arrays.toString(arr));
        }
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int val = arr[i];
            int preIndex = i - 1;
            while (preIndex >= 0 && val < arr[preIndex]) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            // 退出循环代表找到待插入的位置了：preIndex+1
            if (preIndex != i - 1) {
                arr[preIndex + 1] = val;
            }
            System.out.println(i + "排序后: " + Arrays.toString(arr));
        }
    }

    public static void shellSort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int val = arr[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && val < arr[preIndex]) {
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                if (preIndex != i - gap) {
                    arr[preIndex + gap] = val;
                }
                System.out.println(Arrays.toString(arr));
            }
            System.out.println();
        }
    }
}
