package com.example.recursion;

/**
 * 八皇后问题
 */
public class Queen8 {
    // 定义一个max，表示共有多少个皇后
    int max = 8;

    // 定义数组array，保存皇后的位置，比如：arr = {0 , 4, 7, 5, 2, 6, 1, 3}
    int[] array = new int[max];
    static int count = 0;

    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);  // 0：从第一个皇后开始，一直到最后一个皇后
        System.out.printf("一共有%d种解法\n", count);
    }

    /**
     * 放置第n+1个皇后
     *
     * @param n
     */
    private void check(int n) {
        if (n == max) {  // 退出条件： 到这里，前面的八个皇后已经放好了
            print();
            return;
        }

        // 依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            // 先把当前这个皇后n+1，放到该行的第i+1列
            array[n] = i;
            // 判断当放置第n个皇后到i列时，是否冲突
            if (judge(n)) {
                // 如果不冲突,放第n+2个皇后
                check(n + 1);
            }
        }

    }

    /**
     * 查看当我们放置第n+1个皇后时，就去检测该皇后是否和前一个皇后冲突
     *
     * @param n 第n+1个皇后
     * @return 是否ok
     */
    private boolean judge(int n) {
        // 与前面的几个皇后进行比较
        for (int i = 0; i < n; i++) {
            // array[i] == array[n]    如果值相等，说明第n+1个皇后是否和前面的第i个皇后在同一列
            // Math.abs(n - i) == Math.abs(array[n] - array[i])  说明第n+1个皇后是否和前面的第i+1个皇后在同一斜线
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    //写一个方法，可以将结果数组打印出来
    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
