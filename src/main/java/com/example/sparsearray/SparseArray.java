package com.example.sparsearray;

import java.io.*;

/**
 * 二维数组转稀疏数组、稀疏数组转二维数组
 */
public class SparseArray {
    public static void main(String[] args) throws IOException {
        // 1、先创建一个原始的二维数组 11 * 11
        //     0 表示没有棋子；1 表示黑子；2 表示蓝子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[3][4] = 2;
        // 输出原始的二维数组
        System.out.println("原始的二维数组~~");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        // 将二维数组转为稀疏数组，
        // 1、先遍历二维数组，得到非0数据的个数
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[0].length; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        // 2、创建对应的稀疏数组
        int sparseArray[][] = new int[sum + 1][3];
        // 给稀疏数组赋值
        sparseArray[0][0] = chessArr1.length;
        sparseArray[0][1] = chessArr1[0].length;
        sparseArray[0][2] = sum;
        // 遍历二维数组，将非0的值，存放到稀疏数组中
        int count = 1;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[0].length; j++) {
                if (chessArr1[i][j] != 0) {
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArr1[i][j];
                    count++;
                }
            }
        }

        // 输出稀疏数组
        System.out.println();
        System.out.println("得到的稀疏数组为~~~");
        for (int i = 0; i < sparseArray.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArray[i][0], sparseArray[i][1], sparseArray[i][2]);
        }


        // 将稀疏数组恢复成原始的二维数组
        // 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
        int sourceArray[][] = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {  // 第一行不是二维数组的数据，所以i不是从0开始
            int a = sparseArray[i][0];
            int b = sparseArray[i][1];
            int val = sparseArray[i][2];
            sourceArray[a][b] = val;

        }
        // 恢复后的原始二维数组
        System.out.println("\n恢复后的原始二维数组~~~");
        for (int[] row : sourceArray) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }


}
