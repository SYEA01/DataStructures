package com.example.search;

/**
 * 顺序查找
 */
public class SeqSearch {
    public static void main(String[] args) {
        int[] arr = {1, 9, 11, -1, 34, 89};
        int index = sqeSearch(arr, -11);
        if (index == -1) {
            System.out.println("没有查找到");
        } else {
            System.out.println("找到了，下标=" + index);
        }
    }

    /**
     * 线性查找：这里实现的是找到一个满足条件的值就返回
     *
     * @param arr   数组
     * @param value 待查找的值
     * @return 下标
     */
    public static int sqeSearch(int[] arr, int value) {
        // 线性查找是逐一比对
        for (int i = 0; i < arr.length; i++) {
            if (value == arr[i]) {
                return i;
            }
        }
        return -1;
    }
}
