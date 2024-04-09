package com.example.recursion;

public class MiGongTest {
    public static void main(String[] args) {

        int[][] map = new int[8][7];
        for (int i = 0; i < map.length; i++) {  // 0-7
            map[i][0] = 1;
            map[i][map[0].length - 1] = 1;
        }
        for (int i = 0; i < map[0].length; i++) {  // 0-6
            map[0][i] = 1;
            map[map.length - 1][i] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        map[2][2] = 1;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }

        setWay(map,1,1);

        System.out.println("=============================================");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }


    }

    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {  // 此时已经找到通路
            return true;
        } else {  // 还没有走完
            if (map[i][j] == 0) {  // 此时这个路还没有走
                map[i][j] = 2;  // 假设这条路可通
                if (setWay(map, i + 1, j)) {  // 下
                    return true;
                } else if (setWay(map, i, j + 1)) {  // 右
                    return true;
                } else if (setWay(map, i - 1, j)) {  // 上
                    return true;
                } else if (setWay(map, i, j - 1)) {  // 左
                    return true;
                }else {  // 此路不通
                    map[i][j] = 3;
                    return false;
                }
            } else {  // 1墙，2走过了，3此路不通   都返回false
                return false;
            }
        }
    }

}

