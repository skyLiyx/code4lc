package lyx.lc.c33;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 3341.到达最后一个房间的最少时间 I
 *
 * @date 2025/05/07
 */
public class Lc3341 {
    private static final int[] move = {1, 0, -1, 0, 1};

    public int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length;
        int n = moveTime[0].length;
        int[][] distance = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        distance[0][0] = 0;
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        heap.add(new int[]{0, 0, 0});
        while (!heap.isEmpty()) {
            int[] cur = heap.poll();
            int x = cur[0];
            int y = cur[1];
            if (visited[x][y]) {
                continue;
            }
            visited[x][y] = true;
            for (int i = 0, nx, ny; i < 4; i++) {
                nx = x + move[i];
                ny = y + move[i + 1];
                if (nx >= m || nx < 0 || ny >= n || ny < 0) {
                    continue;
                }
                int dist = Math.max(distance[x][y], moveTime[nx][ny]) + 1;
                if (distance[nx][ny] > dist) {
                    distance[nx][ny] = dist;
                    heap.add(new int[]{nx, ny, dist});
                }
            }
        }
        return distance[m - 1][n - 1];
    }
}
