package lyx.lc.c16;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1631. 最小体力消耗路径
 *
 * @apiNote 最短路径 Dijkstra
 */
public class Lc1631 {
    public int minimumEffortPath(int[][] heights) {
        int[] move = {-1, 0, 1, 0, -1};
        int m = heights.length;
        int n = heights[0].length;
        int[][] distance = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparing(a -> a[2]));
        heap.add(new int[]{0, 0, 0});
        distance[0][0] = 0;
        while (!heap.isEmpty()) {
            int[] poll = heap.poll();
            int x = poll[0];
            int y = poll[1];
            int c = poll[2];
            if (x == m - 1 && y == n - 1) {
                return distance[x][y];
            }
            if (!visited[x][y]) {
                visited[x][y] = true;
                for (int i = 0, nx, ny, nc; i < 4; i++) {
                    nx = x + move[i];
                    ny = y + move[i + 1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[nx][ny]) {
                        continue;
                    }
                    nc = Math.max(c, Math.abs(heights[nx][ny] - heights[x][y]));
                    if (nc < distance[nx][ny]) {
                        distance[nx][ny] = nc;
                        heap.add(new int[]{nx, ny, nc});
                    }
                }
            }
        }
        return -1;
    }
}
