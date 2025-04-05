package lyx.lc.c8;

import java.util.Arrays;

/**
 * 864. 获取所有钥匙的最短路径
 *
 * @apiNote 分层图最短路
 */
public class Lc0864 {
    private static final int MAXN = 301;

    private static final int MAXK = 6;

    private static final int[] move = {-1, 0, 1, 0, -1}; // 上右下左

    private static final char[][] charGrid = new char[MAXN][];

    private static final boolean[][][] visited = new boolean[MAXN][MAXN][1 << MAXK];

    // 0-行、1-列、2-收集钥匙的状态
    private static final int[][] queue = new int[MAXN * MAXN * (1 << MAXK)][3];

    private static int l, r, m, n, key;

    private void build(String[] arr) {
        l = r = key = 0;
        m = arr.length;
        n = arr[0].length();
        for (int i = 0; i < m; i++) {
            charGrid[i] = new char[n];
            for (int j = 0; j < n; j++) {
                charGrid[i][j] = arr[i].charAt(j);
                if (charGrid[i][j] == '@') {
                    queue[r][0] = i;
                    queue[r][1] = j;
                    queue[r++][2] = 0;
                }
                if (charGrid[i][j] >= 'a' && charGrid[i][j] <= 'f') {
                    key++;
                }
                Arrays.fill(visited[i][j], false);
            }
        }
    }

    public int shortestPathAllKeys(String[] grid) {
        build(grid);
        int level = 1;
        while (l < r) {
            for (int i = 0, size = r - l; i < size; i++) {
                int x = queue[l][0];
                int y = queue[l][1];
                int s = queue[l++][2];
                for (int j = 0, nx, ny, ns; j < 4; j++) {
                    nx = x + move[j];
                    ny = y + move[j + 1];
                    ns = s;
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n || charGrid[nx][ny] == '#') {
                        // 越界或障碍
                        continue;
                    }
                    char c = charGrid[nx][ny];
                    if (c >= 'A' && c <= 'F' && (ns & (1 << (c - 'A'))) == 0) {
                        // 是锁，但没钥匙
                        continue;
                    }
                    if (c >= 'a' && c <= 'f') {
                        // 获取到钥匙，将其对应二进制位刷成1
                        ns |= (1 << (c - 'a'));
                    }
                    if (ns == key) {
                        return level;
                    }
                    if (!visited[nx][ny][ns]) {
                        queue[r++] = new int[]{nx, ny, ns};
                    }
                }
            }
        }
        return -1;
    }
}
