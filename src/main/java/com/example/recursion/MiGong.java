package com.example.recursion;

/**
 * 迷宫问题
 */
public class MiGong {
    public static void main(String[] args) {
        // 先创建一个二维数组，模拟迷宫    初始化后的二维数组默认值都是0
        int[][] map = new int[8][7];
        // 使用1表示迷宫的墙
        for (int i = 0; i < map.length; i++) {
            map[i][0] = 1;
            map[i][map[0].length - 1] = 1;
        }
        for (int i = 0; i < map[0].length; i++) {
            map[0][i] = 1;
            map[map.length - 1][i] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        map[2][2] = 1;

        // 输出地图迷宫
        System.out.println("原始迷宫地图：");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        setWay(map, 1, 1);

        System.out.println("结束的迷宫地图：");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }

    /**
     * 使用递归回溯来给小球找路
     * <p>
     * 说明：如果小球能到map[6][5] 则说明通路找到
     * <p>
     * 约定：当map[i][j]==0 时，表示该点没有走过；
     * 当map[i][j]==1 时，代表是墙，不能走；
     * 当map[i][j]==2 时，表示是通路，可以走；
     * 当map[i][j]==3 时，表示该位置已经走过，但是走不通
     * <p>
     * 策略：在走迷宫时，先走下，下不通就走右，右不通再走上，上不通再走左。。如果该点走不通，再回溯
     * <p>
     *
     * @param map 表示地图迷宫
     * @param i   表示从哪个位置开始找 (i,j)
     * @param j   表示从哪个位置开始找 (i,j)
     * @return 如果找到通路了，返回true；否则返回false
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {  // 说明通路已经找到
            return true;
        } else {  // 此时没有找到通路
            if (map[i][j] == 0) {  // 如果当前这个点还没有走过
                // 按照策略走：在走迷宫时，先走下，下不通就走右，右不通再走上，上不通再走左。。如果该点走不通，再回溯
                map[i][j] = 2;  // 先假定该点可以走通
                if (setWay(map, i + 1, j)) {  // 先向下走
                    return true;
                } else if (setWay(map, i, j + 1)) {  // 向下走不通，向右走
                    return true;
                } else if (setWay(map, i - 1, j)) {  // 向右走不通，向上走
                    return true;
                } else if (setWay(map, i, j - 1)) {  // 向上走不通，向左走
                    return true;
                } else {  // 走不通，回溯
                    map[i][j] = 3;  // 走不通，置为3
                    return false;
                }
            } else {  // 如果map[i][j]!=0，有3种情况：1（墙），2（已经走过），3（此路不通），不论是哪一种情况，这条路都不可能走了，所以直接返回false
                return false;
            }
        }

    }
}

