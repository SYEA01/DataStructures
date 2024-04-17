package com.example.order;

import java.util.Arrays;

public class OrderTest3 {
    public static void main(String[] args) {
        int[] arr = {8, 0, 2, 3, 9, 5};

        System.out.println("排序前：" + Arrays.toString(arr));
//        bubbleSort(arr);
//        selectSort(arr);
        insertSort(arr);
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
        int insertVal = 0;
        int insertIndex = 0;
        // 从第2个元素开始，往前面的有序列表中插入
        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i];  // 待插入的数
            insertIndex = i - 1;  // 有序数组的最后一个元素
            // 只有当索引>0 并且 待插入的值比有序数组值大的时候，才执行循环
            // 退出循环表示：要么找到列表的开头时，这个待插入的值仍然小；要么待插入的值比有序数组的值大
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            // 退出while循环时，表示找到待插入的位置了：insertIndex+1
            arr[insertIndex + 1] = insertVal;
            System.out.println("第" + i + "次排序：" + Arrays.toString(arr));

        }
    }
}
