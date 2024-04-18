package com.example.order;

import java.util.Arrays;

public class OrderTest2 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{30, 3, 79, 40, 55, 33, 66};
        System.out.println("排序前 = " + Arrays.toString(arr1));
        shellSort(arr1);
        System.out.println("排序后 = " + Arrays.toString(arr1));
        System.out.println();

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
            System.out.println(Arrays.toString(arr));
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
            System.out.println(Arrays.toString(arr));
        }
    }

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
            System.out.println(Arrays.toString(arr));
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
