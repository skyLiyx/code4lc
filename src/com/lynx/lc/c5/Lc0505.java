package com.lynx.lc.c5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 505. 迷宫 II
 *
 * @apiNote 单源最短路径 Dijkstra
 */
public class Lc0505 {
    private final int[] move = {-1, 0, 1, 0, -1};

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] distance = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparing(a -> a[2]));
        heap.add(new int[]{start[0], start[1], 0});
        distance[start[0]][start[1]] = 0;
        while (!heap.isEmpty()) {
            int[] record = heap.poll();
            int x = record[0];
            int y = record[1];
            if (x == destination[0] && y == destination[1]) {
                return distance[x][y];
            }
            // 上、右、下、左移动
            for (int i = 0, nx, ny, d; i < 4; i++) {
                nx = x;
                ny = y;
                d = 0;
                while (nx + move[i] >= 0 && nx + move[i] < m && ny + move[i + 1] >= 0 && ny + move[i + 1] < n
                        && maze[nx + move[i]][ny + move[i + 1]] != 1) {
                    nx += move[i];
                    ny += move[i + 1];
                    d++;
                }
                if (distance[x][y] + d < distance[nx][ny]) {
                    distance[nx][ny] = distance[x][y] + d;
                    heap.add(new int[]{nx, ny, distance[nx][ny]});
                }
            }
        }
        return -1;
    }
}
