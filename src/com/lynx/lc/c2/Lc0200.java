package com.lynx.lc.c2;

/**
 * 200. 岛屿数量
 *
 * @apiNote 并查集/DFS + 洪水填充
 */
public class Lc0200 {

    /* ******************************并查集版本****************************** */
    private final int[] father = new int[90000];

    private int sets;

    private int row, col;

    private void build(char[][] grid) {
        row = grid.length;
        col = grid[0].length;
        sets = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    int index = index(i, j);
                    father[index] = index;
                    sets++;
                }
            }
        }
    }

    private int find(int i) {
        if (i != father[i]) {
            father[i] = find(father[i]);
        }
        return father[i];
    }

    private void union(int row1, int col1, int row2, int col2) {
        int fa = find(index(row1, col1));
        int fb = find(index(row2, col2));
        if (fa != fb) {
            father[fa] = fb;
            sets--;
        }
    }

    private int index(int i, int j) {
        return i * col + j;
    }

    public int numIslands_ufs(char[][] grid) {
        build(grid);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    if (i > 0 && grid[i - 1][j] == '1') {
                        union(i, j, i - 1, j);
                    }
                    if (j > 0 && grid[i][j - 1] == '1') {
                        union(i, j, i, j - 1);
                    }
                }
            }
        }
        return sets;
    }
    /* ******************************并查集版本****************************** */

    /* ****************************DFS + 洪水填充**************************** */
    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    dfs(grid, i, j);
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[i].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = 0;
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
    /* ****************************DFS + 洪水填充**************************** */
}
