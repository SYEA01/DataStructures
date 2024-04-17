package com.example.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 希尔排序
 * 排序前 = 2024-04-17 17:35:45
 * 排序后 = 2024-04-17 17:35:50
 * 80000 条数据耗时5秒
 */
public class ShellSort {
    public static void main(String[] args) {
//        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};

        //
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);  // 生成 [0,800000) 的随机数
        }
        Date date1 = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("排序前 = " + sdf.format(date1));

        shellSort(arr);

        Date date2 = new Date();
        System.out.println("排序后 = " + sdf.format(date2));
    }


    /**
     * 希尔排序
     *
     * @param arr
     */
    public static void shellSort(int[] arr) {
        int temp;
        int len = arr.length;
        // 初始增量为len/2，不断缩小增量直至为1 【 控制每次比较的组数，从数组长度的一半开始逐渐减小，直到为1。 】
        for (int gap = len / 2; gap > 0; gap /= 2) {
            // 对每个子序列进行插入排序  【 遍历每个子序列，对每个子序列进行插入排序。 】
            for (int i = gap; i < len; i++) {
                // 遍历各组中所有的元素（共gap组 ）【 用于比较相邻的元素，并进行交换，直到找到正确的位置。 】
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }


//        // 希尔排序第1轮
//        for (int i = 5; i < arr.length; i++) { i:5,6,7,8,9
//            // 遍历各组重所有的元素（共5组）
//            for (int j = i - 5; j >= 0; j -= 5) {
//                if (arr[j] > arr[j + 5]) {
//                    temp = arr[j];
//                    arr[j] = arr[j + 5];
//                    arr[j + 5] = temp;
//                }
//            }
//        }
//        System.out.println("希尔排序第1轮 = " + Arrays.toString(arr));
//        // 希尔排序第2轮
//        for (int i = 2; i < arr.length; i++) { i:2,3,4,5,6,7,8,9
//            // 遍历各组重所有的元素
//            for (int j = i - 2; j >= 0; j -= 2) {
//                if (arr[j] > arr[j + 2]) {
//                    temp = arr[j];
//                    arr[j] = arr[j + 2];
//                    arr[j + 2] = temp;
//                }
//            }
//        }
//        System.out.println("希尔排序第2轮 = " + Arrays.toString(arr));
//
//        // 希尔排序第3轮
//        for (int i = 1; i < arr.length; i++) {
//            // 遍历各组重所有的元素
//            for (int j = i - 1; j >= 0; j -= 1) {
//                if (arr[j] > arr[j + 1]) {
//                    temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                }
//            }
//        }
//        System.out.println("希尔排序第3轮 = " + Arrays.toString(arr));

    }


}
