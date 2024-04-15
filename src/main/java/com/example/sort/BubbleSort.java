package com.example.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 冒泡排序
 * 排序前 = 2024-04-15 17:54:21
 * 排序后 = 2024-04-15 17:54:30
 * 80000条数据花费9秒
 */
public class BubbleSort {
    public static void main(String[] args) {
//        int[] arr = {0, 5, 3, 7, 2};
//        System.out.println("排序前的数组 = " + Arrays.toString(arr));

        // 测试冒泡排序的速度O(n^2)
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);  // 生成 [0,800000) 的随机数
        }
        Date date1 = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("排序前 = " + sdf.format(date1));

        bubbleSort(arr);

        Date date2 = new Date();
        System.out.println("排序后 = " + sdf.format(date2));


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
