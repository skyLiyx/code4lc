package com.lynx.lc.c7;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 778. 水位上升的泳池中游泳
 *
 * @apiNote Dijkstra 算法
 */
public class Lc0778 {
    public int swimInWater(int[][] grid) {
        int[] move = {-1, 0, 1, 0, -1};
        int n = grid.length;
        int[][] distance = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparing(a -> a[2]));
        heap.add(new int[]{0, 0, grid[0][0]});
        distance[0][0] = grid[0][0];
        while (!heap.isEmpty()) {
            int[] poll = heap.poll();
            int x = poll[0];
            int y = poll[1];
            if (x == n - 1 && y == n - 1) {
                return distance[x][y];
            }
            if (!visited[x][y]) {
                visited[x][y] = true;
                for (int i = 0, nx, ny; i < 4; i++) {
                    nx = x + move[i];
                    ny = y + move[i + 1];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) {
                        continue;
                    }
                    if (Math.max(distance[x][y], grid[nx][ny]) < distance[nx][ny]) {
                        distance[nx][ny] = Math.max(distance[x][y], grid[nx][ny]);
                        heap.add(new int[]{nx, ny, distance[nx][ny]});
                    }
                }
            }
        }
        return -1;
    }
}
