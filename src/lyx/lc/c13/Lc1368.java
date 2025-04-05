package lyx.lc.c13;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 1368. 使网格图至少有一条有效路径的最小代价
 *
 * @apiNote 01BFS
 */
public class Lc1368 {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 1向右走，2向左走，3向下走，4向上走
        int[][] move = {{}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        // 最短距离
        int[][] distance = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
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
            // 按照move的右左下上移动
            for (int i = 1, nx, ny, weight; i <= 4; i++) {
                nx = x + move[i][0];
                ny = y + move[i][1];
                // 如果当前位置的值代表的方向和移动方向一致，权值就是0，否则就是1
                weight = grid[x][y] == i ? 0 : 1;
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && weight + distance[x][y] < distance[nx][ny]) {
                    distance[nx][ny] = weight + distance[x][y];
                    if (weight == 0) {
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
