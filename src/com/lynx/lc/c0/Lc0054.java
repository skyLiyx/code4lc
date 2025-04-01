package com.lynx.lc.c0;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 */
public class Lc0054 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int count = m * n;
        // 右，下，左，上 + 移动次数
        int[][] move = {
                {0, 1, n},
                {1, 0, m - 1},
                {0, -1, n - 1},
                {-1, 0, m - 2},
        };
        List<Integer> ans = new ArrayList<>();
        int x = 0, y = -1;
        int direction = 0;
        while (count > 0) {
            // 当前方向移动
            for (int i = 0; i < move[direction][2]; i++) {
                x += move[direction][0];
                y += move[direction][1];
                ans.add(matrix[x][y]);
                count--;
            }
            // 由于两边各减少一个，下一次当前方向的移动次数 -2
            move[direction][2] -= 2;
            // 下一个方向
            direction = (direction + 1) % 4;
        }
        return ans;
    }
}
