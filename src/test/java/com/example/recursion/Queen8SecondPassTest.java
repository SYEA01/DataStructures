package com.example.recursion;

/**
 * 第二遍八皇后问题
 */
public class Queen8SecondPassTest {

    int max = 8;
    int[] array = new int[max];  // 索引代表行，值代表列

    static int count = 0;

    public static void main(String[] args) {
        Queen8SecondPassTest queen8SecondPassTest = new Queen8SecondPassTest();
        queen8SecondPassTest.demo(0);
        System.out.println("count = " + count);
    }

    // 打印结果的方法
    private void print() {
        count++;
        for (int i = 0; i < max; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }

    // 将当前皇后与之前所有皇后进行比较，判断是否合理的方法
    private boolean isOk(int n) {
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    // 递归方法
    private void demo(int n) {
        if (n == max) {  // 退出递归条件
            print();
            return;
        }

        // 每一列都挨个去试
        for (int i = 0; i < max; i++) {
            array[n] = i;  // 将第n+1个皇后，在每一列都去试试
            if (isOk(n)) {  // 如果合理，就去下一行，去放置下一个皇后。 如果不合理的话，就通过for循环将此皇后放到下一列试
                demo(n + 1);
            }
        }
    }


}
