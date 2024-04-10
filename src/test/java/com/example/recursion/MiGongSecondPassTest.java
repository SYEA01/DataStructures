package com.example.recursion;

/**
 * 第二遍迷宫问题
 */
public class MiGongSecondPassTest {
    public static void main(String[] args) {
        // 定义一个数组表示迷宫
        int[][] map = new int[8][7];
        for (int i = 0; i < map.length; i++) {
            map[i][0] = 1;
            map[map[0].length - 1][0] = 1;
        }
        for (int i = 0; i < map[0].length; i++) {
            map[0][i] = 1;
            map[map.length - 1][i] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        map[2][2] = 1;

        System.out.println("初始迷宫========================|");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }

        setWay(map, 1, 1);

        System.out.println("结果========================|");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }


    }

    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {  // 如果走到终点了
            return true;
        } else {  // 没有走到终点
            if (map[i][j] == 0) {  // 如果这个点没走过
                map[i][j] = 2;
                if (setWay(map, i + 1, j)) {  // 下
                    return true;
                } else if (setWay(map, i, j + 1)) {  // 右
                    return true;
                } else if (setWay(map, i - 1, j)) {  // 上
                    return true;
                } else if (setWay(map, i, j - 1)) {  // 左
                    return true;
                } else {  // 都不通的话，将该点状态改成3（不通），返回false
                    map[i][j] = 3;
                    return false;
                }
            } else {  // 1（墙），2（走过），3（走过，不通）都返回false
                return false;
            }
        }
    }

}
