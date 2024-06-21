package com.example.order;

import java.util.Arrays;

/**
 * 手写排序
 */
public class OrderTest {
    public static void main(String[] args) {
        int[] arr1 = new int[]{30, 3, 79, 40, 55, 33, 66};
        int[] arr2 = new int[]{30, 3, 79, 40, 55, 33, 66};
        int[] arr3 = new int[]{30, 3, 79, 40, 55, 33, 66};
        int[] arr4 = new int[]{30, 3, 79, 40, 55, 33, 66};
        int[] arr5 = new int[]{30, 3, 79, 40, 55, 33, 66};
        int[] arr6 = new int[]{30, 3, 79, 40, 55, 33, 66};
        int[] arr7 = new int[]{30, 3, 79, 40, 55, 33, 66};
        System.out.println("冒泡排序前 = " + Arrays.toString(arr1));
        bubbleSort(arr1);
        System.out.println("冒泡排序后 = " + Arrays.toString(arr1));
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("选择排序前 = " + Arrays.toString(arr2));
        selectSort(arr2);
        System.out.println("选择排序后 = " + Arrays.toString(arr2));
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("插入排序前 = " + Arrays.toString(arr3));
        insertSort(arr3);
        System.out.println("插入排序后 = " + Arrays.toString(arr3));

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("希尔排序前 = " + Arrays.toString(arr4));
        shellSort(arr4);
        System.out.println("希尔排序后 = " + Arrays.toString(arr4));

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("快速排序前 = " + Arrays.toString(arr5));
        quickSort(arr5, 0, arr5.length - 1);
        System.out.println("快速排序后 = " + Arrays.toString(arr5));

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("归并排序前 = " + Arrays.toString(arr6));
        int[] temp = new int[arr6.length];
        mergeSort(arr6, 0, arr5.length - 1, temp);
        System.out.println("归并排序后 = " + Arrays.toString(arr6));

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("基数排序前 = " + Arrays.toString(arr7));
        radixSort(arr7);
        System.out.println("基数排序后 = " + Arrays.toString(arr7));
    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        boolean flag = false;
        // 因为两两比较，需要n-1次大循环
        for (int i = 0; i < arr.length - 1; i++) {
            // 因为末尾的元素已经排过序了，所以减去已经排过序的元素
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 如果前一个元素大，交换位置
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("第" + (i + 1) + "次排序：" + Arrays.toString(arr));
            if (Boolean.FALSE == flag) {  // 如果没有交换过位置，证明已经有序了，就退出
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
            System.out.println("第" + (i + 1) + "次排序：" + Arrays.toString(arr));
        }
    }


    /**
     * 插入排序
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertValue = arr[i];
            int prefixIndex = i - 1;
            while (prefixIndex >= 0 && insertValue < arr[prefixIndex]) {
                arr[prefixIndex + 1] = arr[prefixIndex];
                prefixIndex--;
            }
            if (prefixIndex != i - 1) {
                arr[prefixIndex + 1] = insertValue;
            }
            System.out.println("第" + i + "次排序：" + Arrays.toString(arr));
        }
    }

    /**
     * 希尔排序 （缩小增量排序）
     *
     * @param arr
     */
    public static void shellSort(int[] arr) {
        // gap代表增量。
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                // 待插入数据
                int insertValue = arr[gap];
                // 有序列表的最后一个索引
                int prefixIndex = i - gap;
                // 开始循环找待插入位置
                while (prefixIndex >= 0 && insertValue < arr[prefixIndex]) {
                    arr[prefixIndex + gap] = arr[prefixIndex];
                    prefixIndex -= gap;
                }
                if (prefixIndex != i - gap) {
                    arr[prefixIndex + gap] = insertValue;
                }
            }
        }
    }

    /**
     * 快速排序
     *
     * @param arr
     * @param left
     * @param right
     */
    private static void quickSort(int[] arr, int left, int right) {
        // 1、首先定义左右两个指针，并查找中间值
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];
        // 2、利用循环将pivot左边的值移动成比pivot小，右边的值比pivot大
        while (l < r) {
            // 2.1、分别查找左边大的值，和右边小的值
            while (arr[l] < pivot) {
                l++;
            }
            while (arr[r] > pivot) {
                r--;
            }
            // 2.2、判断l或者r是否都指向pivot了，如果都指向了，说明已经设置完成了
            if (l == r) {
                break;
            }
            // 2.3、交换值
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            // 2.4、判断特殊情况：为了避免重复比较，移动指针
            if (arr[r] == pivot) {
                l++;
            }
            if (arr[l] == pivot) {
                r--;
            }
        }

        if (l == r) {
            l++;
            r--;
        }

        // 4、递归分别移动左右两部分
        if (l < right) {
            quickSort(arr, l, right);
        }
        if (r > left) {
            quickSort(arr, left, r);
        }
    }

    /**
     * 归并排序
     *
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            // 向左拆分
            mergeSort(arr, left, mid, temp);

            // 向右拆分
            mergeSort(arr, mid + 1, right, temp);

            merge(arr, left, mid, right, temp);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;

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

        t = 0;
        int leftIndex = left;
        while (leftIndex <= right) {
            arr[leftIndex] = temp[t];
            leftIndex++;
            t++;
        }
    }

    /**
     * 基数排序
     *
     * @param arr
     */
    public static void radixSort(int[] arr) {
        int length = arr.length;
        if (length < 2) {
            return;
        }
        // 首先先找到这个数组中最大数的位数
        int max = arr[0];
        for (int i = 1; i < length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();

        // 然后定义一个二维数组，代表10个桶  0-9
        int[][] bucket = new int[10][length];
        // 定义一个一维数组，表示这10个桶中元素的个数
        int[] bucketElementCount = new int[10];

        // 然后从个位数开始依次去每一位，并将其放入到对于的桶中
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int j = 0; j < length; j++) {
                int element = arr[j] / n % 10;
                bucket[element][bucketElementCount[element]] = arr[j];
                bucketElementCount[element]++;
            }
            // 放回原数组
            int index = 0;
            for (int k = 0; k < 10; k++) {
                if (bucketElementCount[k] != 0) {
                    for (int l = 0; l < bucketElementCount[k]; l++) {
                        arr[index++] = bucket[k][l];
                    }
                }
                bucketElementCount[k] = 0;
            }
            System.out.println("第" + (i + 1) + "轮处理：" + Arrays.toString(arr));
        }


    }
}
