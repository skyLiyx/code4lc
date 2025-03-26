package com.lynx.lc.c27;

import java.util.HashMap;
import java.util.Map;

/**
 * 2711. 对角线上不同值的数量差
 *
 * @date 2024/03/25
 */
public class Lc2711 {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m][n];
        Map<Integer, Integer> topLeft = new HashMap<>();
        Map<Integer, Integer> bottomRight = new HashMap<>();
        for (int row = 0, r, c; row < m - 1; row++) {
            r = row + 1;
            c = 1;
            while (r < m && c < n) {
                bottomRight.compute(grid[r][c], (k, v) -> v == null ? 1 : v + 1);
                r++;
                c++;
            }
            ans[row][0] = bottomRight.size();
            r = row + 1;
            c = 1;
            while (r < m && c < n) {
                if (bottomRight.get(grid[r][c]) == 1) {
                    bottomRight.remove(grid[r][c]);
                } else {
                    bottomRight.put(grid[r][c], bottomRight.get(grid[r][c]) - 1);
                }
                topLeft.compute(grid[r - 1][c - 1], (k, v) -> v == null ? 1 : v + 1);
                ans[r][c] = Math.abs(bottomRight.size() - topLeft.size());
                r++;
                c++;
            }
            bottomRight.clear();
            topLeft.clear();
        }
        for (int col = 1, r, c; col < n - 1; col++) {
            r = 1;
            c = col + 1;
            while (r < m && c < n) {
                bottomRight.compute(grid[r][c], (k, v) -> v == null ? 1 : v + 1);
                r++;
                c++;
            }
            ans[0][col] = bottomRight.size();
            r = 1;
            c = col + 1;
            while (r < m && c < n) {
                if (bottomRight.get(grid[r][c]) == 1) {
                    bottomRight.remove(grid[r][c]);
                } else {
                    bottomRight.put(grid[r][c], bottomRight.get(grid[r][c]) - 1);
                }
                topLeft.compute(grid[r - 1][c - 1], (k, v) -> v == null ? 1 : v + 1);
                ans[r][c] = Math.abs(bottomRight.size() - topLeft.size());
                r++;
                c++;
            }
            bottomRight.clear();
            topLeft.clear();
        }
        return ans;
    }
}
