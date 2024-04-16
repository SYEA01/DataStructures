package com.example.order;

import java.util.Arrays;

public class OrderTest2 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{30, 3, 79, 40, 55, 33, 66};
        int[] arr2 = new int[]{30, 3, 79, 40, 55, 33, 66};
        int[] arr3 = new int[]{30, 3, 79, 40, 55, 33, 66};
        System.out.println("冒泡排序前 = " + Arrays.toString(arr1));
        insertSort(arr1);
        System.out.println("冒泡排序后 = " + Arrays.toString(arr1));
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
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }
}
