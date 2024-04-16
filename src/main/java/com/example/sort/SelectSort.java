package com.example.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 选择排序
 * 排序前 = 2024-04-16 14:43:03
 * 排序后 = 2024-04-16 14:43:05
 * 80000条数据花费2秒
 */
public class SelectSort {
    public static void main(String[] args) {
//        int[] arr = {5, 9, 3, 7, 1, -1, 90};

        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        Date date1 = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("排序前 = " + sdf.format(date1));

        // 选择排序  时间复杂度 O(n^2)
        selectSort(arr);

        Date date2 = new Date();
        System.out.println("排序后 = " + sdf.format(date2));

    }

    /**
     * 选择排序
     *
     * @param arr
     */
    private static void selectSort(int[] arr) {
        // n-1轮 大的循环
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int index = i;
            // 依次找最小值
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    index = j;
                }
            }

            // 找到了之后，进行交换
            if (index != i) {
                arr[index] = arr[i];
                arr[i] = min;
            }
        }
    }
}
