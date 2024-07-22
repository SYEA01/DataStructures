package com.example.search;

import java.util.Arrays;

/**
 * 斐波那契查找
 */
public class FibonacciSearch {

    public static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        int i = fibonacciSearch(arr, 89);
        System.out.println("i = " + i);
    }


    /**
     * 斐波那契查找
     *
     * @param arr    数组
     * @param target 需要查找的值
     * @return 对应的下标，如果没有就返回-1
     */
    public static int fibonacciSearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int k = 0;  // k 表示斐波那契分割数值的下标
        int mid = 0;  // 先初始化为0
        int[] f = fibonacci();  // 获取到斐波那契数列
        // 获取到斐波那契分割数值的下标，（要确保数组的长度 比 斐波那契数字 大一个）
        while (right > f[k] - 1) {
            k++;
        }

        // 因为f[k] 的值可能大于数组的长度right，因此需要使用Arrays构造一个新的数组，并指向temp，剩余的部分使用0填充
        int[] temp = Arrays.copyOf(arr, f[k]);
        for (int i = right + 1; i < temp.length; i++) {
            temp[i] = arr[right];
        }

        // 使用while循环来找到target
        while (left <= right) {
            // 将数组分成两部分，左部分长度为f[k-1]，右部分长度为f[k-2]
            mid = left + f[k - 1] - 1;  // 这里后面再-1 代表除去mid占用的这一个位置。也就是mid的左边是f[k-1]个元素，mid的右边是f[k-2]个元素
            if (target < temp[mid]) {
                right = mid - 1;
                // f[k] = f[k-1] + f[k-2];
                // 因为前面有f[k-1]个元素，所以可以继续拆分 f[k-1] = f[k-2] + f[k-3];
                // 即在f[k-1] 的前面继续查找
                // 举例：  1，1，2，3，5，8，13，21   21 = 8 + 13     变成了 8 = 3 + 5
                // 也就是在左半部分进行继续查找；下面同理，在右半部分进行查找
                k--;
            } else if (target > temp[mid]) {
                left = mid + 1;
                // f[k-2] = f[k-3] + f[k-4]
                // 即在f[k-2]的前面继续查找
                k -= 2;
            } else {
                // 因为我们在搜索过程中对数组进行了扩展，使用了temp数组，其长度为f[k]，这可能比原始数组arr的长度还要长。
                // 在temp数组中，我们只关心前right + 1个元素，因为这部分包含了原始数组arr的所有元素。因此，当我们找到目标值时，需要判断这个mid是否在我们真正关心的范围内，即mid是否小于等于right。
                // 如果mid <= right，这意味着mid确实位于我们关心的原始数组范围内，因此可以直接返回mid作为目标值的索引。
                // 如果mid > right，这意味着mid实际上超出了原始数组范围，但由于我们在扩展数组时将arr[right]的值复制到了temp数组的超出部分，因此temp[mid]和arr[right]实际上是相等的。在这种情况下，我们返回right作为目标值的索引，因为right是原始数组中与temp[mid]对应的位置。
                // 这样设计的原因在于保证返回的索引始终对应于原始数组arr中的位置，即使在扩展后的temp数组中进行了查找。
                if (mid <= right) {
                    return mid;
                } else {
                    return right;
                }
            }
        }
        return -1;
    }

    /**
     * 因为斐波那契查找算法计算 mid=left+F(K-1)-1 ,需要使用到斐波那契数列，因此需要先构建一个斐波那契数列
     * <p>
     * 非递归的方式得到一个斐波那契数列
     *
     * @return 斐波那契数列
     */
    public static int[] fibonacci() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }
}
