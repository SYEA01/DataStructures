package com.example.recursion;

/**
 * 递归
 */
public class RecursionTest {
    public static void main(String[] args) {
        test(5);
    }

    /**
     * 打印问题
     * @param n
     */
    public static void test(int n) {
        if (n > 2) {
            test(n - 1);
        }
        System.out.println("n = " + n);
    }
}
