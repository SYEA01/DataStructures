package com.example.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] temp = new int[arr.length];  // 归并排序需要一个额外的空间
        mergeSort(arr, 0, arr.length - 1, temp);

        System.out.println("归并排序后：" + Arrays.toString(arr));

    }

    /**
     * 分
     *
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {  // 递归的退出条件
            int mid = (left + right) / 2;
            // 向左递归进行分解
            mergeSort(arr, left, mid, temp);
            // 向右递归进行分解
            mergeSort(arr, mid + 1, right, temp);

            // 到合并
            merge(arr, left, mid, right, temp);
        }

    }


    /**
     * 治
     * 合并并排序的方法
     * 就是将 从【 left ~ mid 】的部分和从【 mid+1 ~ right 】的部分 的两个有序数组合并成一个
     * @param arr   待排序的数组
     * @param left  左边有序序列的初始索引
     * @param mid   中间索引（分隔左右两边）
     * @param right 右边索引
     * @param temp  做中转的数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;  // 初始化i，左边有序数组的初始索引
        int j = mid + 1;  // 初始化j，右边有序数组的初始索引
        int t = 0;  // 指向临时数组temp的当前索引

        // 1、先把左右两个有序数组的数据 按规则 填充到temp中（将两个有序数组合并成一个有序数组）
        // 直到左右两个数组有一个数组的数据填充完毕为止
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            } else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }

        // 2、把剩余数据的数组的数据，依次全部填充到temp中
        while (i <= mid) {
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right) {
            temp[t] = arr[j];
            t++;
            j++;
        }

        // 3、将temp数组重新拷贝到arr数组
        // 并不是每次都拷贝所有的
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }

    }
}
