package com.example.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 插入排序
 * 排序前 = 2024-04-16 16:51:57
 * 排序后 = 2024-04-16 16:51:59
 * 80000条数据花费2秒
 */
public class InsertSort {
    public static void main(String[] args) {
//        int[] arr = {101, 34, 119, 1, -1, 33};
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);  // 生成 [0,800000) 的随机数
        }
        Date date1 = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("排序前 = " + sdf.format(date1));

        insertSort(arr);

        Date date2 = new Date();
        System.out.println("排序后 = " + sdf.format(date2));
    }

    /**
     * 插入排序
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {

        // 从第2个数字开始循环
        for (int i = 1; i < arr.length; i++) {
            // 遍历前面的有序数组
            for (int j = 0; j < i; j++) {
                // 找位置进行插入
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
//            System.out.println("第" + i + "次：" + Arrays.toString(arr));
        }
    }
}
