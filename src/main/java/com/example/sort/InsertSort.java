package com.example.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
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
        int[] arr = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = (int) (Math.random() * 80);  // 生成 [0,800000) 的随机数
        }
        Date date1 = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("排序前 = " + sdf.format(date1));
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));

        insertSort(arr);

        Date date2 = new Date();
        System.out.println("排序后 = " + sdf.format(date2));
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }

    /**
     * 插入排序
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {

        // 从第2个数字开始循环
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];  // 待插入的值
            int insertIndex = i - 1;  // 有序列表的最后一个值的索引
            // 循环去找待插入的位置
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            // 当退出while循环时，代表已经找到待插入的位置了。 要么是直到开头都比这个值大；要么是找到位置。这个位置的索引就是 insertIndex+1

            if (insertVal != i - 1) {  // 如果没有进入循环，代表此时这个待插入的值比有序列表的所有值都大
                arr[insertIndex + 1] = insertVal;
            }
//            System.out.println("第" + i + "次：" + Arrays.toString(arr));
        }
    }
}
