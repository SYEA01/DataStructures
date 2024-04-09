package com.example.recursion;

public class Queen8Test {
    int max = 8;

    // 模拟八皇后数组，这里使用一维数组，其中索引0-7分别代表第1-8行，对应的值代表这个皇后在这一行的哪一列
    int[] array = new int[max];
    static int count = 0;

    public static void main(String[] args) {
        Queen8Test queen8Test = new Queen8Test();
        queen8Test.demo(0);  // 从第0行开始添加
        System.out.println("count = " + count);
    }

    /**
     * 这里开始递归调用了
     * 这里n是行，i是列
     *
     * @param n 行
     */
    private void demo(int n) {
        if (n == max) {  // 这里表示某一个方式的八皇后数组合理了
            print();
            return;
        }
        // 去试每一列
        for (int i = 0; i < max; i++) {
            array[n] = i;  // 首先假设第n+1行的皇后，在第i+1列合理，然后利用isOk方法去判断放在这一列是否可以
            if (isOk(n)) {  // 如果合理，那么上面的array[n] = i; 就成立了。 否则依次往后数列，看哪里合理
                // 上面成立了之后，然后再看下一行的皇后
                demo(n + 1);
            }
        }

    }


    /**
     * 判断这个皇后的位置是否合理
     * 跟之前的每一个皇后分别进行对比，看是否合理
     *
     * @param n
     * @return 是否合理
     */
    private boolean isOk(int n) {
        // 将这个皇后的位置与它之前的每一个皇后的位置分别一一对比
        for (int i = 0; i < n; i++) {
            // 判断它与它之前的皇后是否在同一列、是否在同一条斜线上，如果在同一列，或者同一斜线上，就不合理
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 打印这个八皇后数组
     */
    private void print() {
        count++;
        for (int i = 0; i < max; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
