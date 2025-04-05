package lyx.lc.c22;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 2290. 到达角落需要移除障碍物的最小数目
 *
 * @apiNote 01BFS
 */
public class Lc2290 {
    public int minimumObstacles(int[][] grid) {
        // 辅助移动
        int[] next = {-1, 0, 1, 0, -1};
        int m = grid.length;
        int n = grid[0].length;
        // 初始化最短距离数组
        int[][] distance = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        // 01BFS
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addFirst(new int[]{0, 0});
        distance[0][0] = 0;
        while (!deque.isEmpty()) {
            int[] cur = deque.pollFirst();
            int x = cur[0];
            int y = cur[1];
            if (x == m - 1 && y == n - 1) {
                return distance[x][y];
            }
            for (int i = 0, nx, ny; i < 4; i++) {
                nx = x + next[i];
                ny = y + next[i + 1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n &&
                        grid[nx][ny] + distance[x][y] < distance[nx][ny]) {
                    distance[nx][ny] = grid[nx][ny] + distance[x][y];
                    if (grid[nx][ny] == 0) {
                        deque.addFirst(new int[]{nx, ny});
                    } else {
                        deque.addLast(new int[]{nx, ny});
                    }
                }
            }
        }
        return -1;
    }
}
