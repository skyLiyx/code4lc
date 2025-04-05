package lyx.lc.c9;

/**
 * 994. 腐烂的橘子
 *
 * @apiNote bfs
 */
public class Lc0994 {
    private static final int[] move = {-1, 0, 1, 0, -1};
    private static final int[][] queue = new int[101][2];
    private static int l, r;

    public int orangesRotting(int[][] grid) {
        l = r = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue[r++] = new int[]{i, j};
                }
            }
        }
        int ans = r == 0 ? 0 : bfs(grid);
        for (int[] row : grid) {
            for (int i : row) {
                if (i == 1) {
                    return -1;
                }
            }
        }
        return ans;
    }

    private int bfs(int[][] grid) {
        int level = 0;
        while (l < r) {
            int size = r - l;
            for (int i = 0, x, y; i < size; i++) {
                x = queue[l][0];
                y = queue[l++][1];
                for (int j = 0, nx, ny; j < 4; j++) {
                    nx = x + move[j];
                    ny = y + move[j + 1];
                    if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[nx].length || grid[nx][ny] != 1) {
                        continue;
                    }
                    queue[r++] = new int[]{nx, ny};
                    grid[nx][ny] = 2;
                }
            }
            level++;
        }
        return level - 1;
    }
}
