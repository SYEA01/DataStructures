package com.example.sort;

import java.util.Arrays;

/**
 * 基数排序
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        radixSort(arr);
    }

    public static void radixSort(int[] arr) {

        // 首先找数组中最大的数的位数
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();


        // 二维数组包含10个一维数组。代表0-9
        int[][] bucket = new int[10][arr.length];

        // 为了记录，每一个桶中实际存放了多少个数据，定义一个一维数组，来记录各个桶的每次放入的数据的个数
        int[] bucketElementCounts = new int[10];

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            // 将元素的某一位数先按照顺序放到桶中
            for (int j = 0; j < arr.length; j++) {
                // 取出每个元素的个位
                int digitOfElement = arr[j] / n % 10;
                // 放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }

            // 从桶中取出，放回原数组
            int index = 0;
            for (int k = 0; k < 10; k++) {
                // 如果桶中有数据，才放入到原数组
                if (bucketElementCounts[k] != 0) {
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        arr[index++] = bucket[k][l];
                    }
                }
                bucketElementCounts[k] = 0;
            }
            System.out.println("第" + (i + 1) + "轮的处理：" + Arrays.toString(arr));
        }
    }
}
