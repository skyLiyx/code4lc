package com.lynx.lc.c4;

import java.util.Arrays;

/**
 * 490. 迷宫
 *
 * @apiNote dfs
 */
public class Lc0490 {
    private static final boolean[][] visited = new boolean[101][101];
    private static final int[] move = {-1, 0, 1, 0, -1};

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        for (int i = 0; i < maze.length; i++) {
            Arrays.fill(visited[i], false);
        }
        return dfs(maze, destination, start);
    }

    private boolean dfs(int[][] maze, int[] destination, int[] cur) {
        if (Arrays.equals(cur, destination)) {
            return true;
        }
        boolean found = false;
        int x = cur[0];
        int y = cur[1];
        for (int i = 0, nx, ny; i < 4; i++) {
            nx = x;
            ny = y;
            while (nx + move[i] < maze.length && nx + move[i] >= 0 &&
                    ny + move[i + 1] < maze[0].length && ny + move[i + 1] >= 0 &&
                    maze[nx + move[i]][ny + move[i + 1]] == 0) {
                nx += move[i];
                ny += move[i + 1];
            }
            if (!visited[nx][ny]) {
                visited[nx][ny] = true;
                found = found || dfs(maze, destination, new int[]{nx, ny});
            }
        }
        return found;
    }
}
