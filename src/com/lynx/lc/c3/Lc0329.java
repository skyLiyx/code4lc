package com.lynx.lc.c3;

import java.util.Arrays;

/**
 * 329. 矩阵中的最长递增路径
 *
 * @apiNote 拓扑排序
 */
public class Lc0329 {
    private static final int MAXN = 40001;
    private static final int MAXM = 80001;

    private static final int[] head = new int[MAXN];
    private static final int[] next = new int[MAXM];
    private static final int[] to = new int[MAXM];
    private int cnt;

    private final int[] indegree = new int[MAXN];

    private final int[] queue = new int[MAXN];

    private int n, row, col;

    private void build() {
        n = row * col;
        cnt = 1;
        Arrays.fill(head, 0, n, 0);
        Arrays.fill(indegree, 0, n, 0);
    }

    private void addEdge(int r1, int c1, int r2, int c2) {
        int f = index(r1, c1);
        int t = index(r2, c2);
        next[cnt] = head[f];
        to[cnt] = t;
        head[f] = cnt++;
        indegree[t]++;
    }

    public int longestIncreasingPath(int[][] matrix) {
        row = matrix.length;
        col = matrix[0].length;
        build();
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                int cur = matrix[r][c];
                if (r - 1 >= 0 && matrix[r - 1][c] > cur) {
                    addEdge(r, c, r - 1, c);
                }
                if (r + 1 < row && matrix[r + 1][c] > cur) {
                    addEdge(r, c, r + 1, c);
                }
                if (c - 1 >= 0 && matrix[r][c - 1] > cur) {
                    addEdge(r, c, r, c - 1);
                }
                if (c + 1 < col && matrix[r][c + 1] > cur) {
                    addEdge(r, c, r, c + 1);
                }
            }
        }
        int l = 0, r = 0;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue[r++] = i;
            }
        }
        int[] path = new int[n];
        int ans = 0;
        while (l < r) {
            int cur = queue[l++];
            path[cur]++;
            if (head[cur] == 0 && path[cur] > ans) {
                ans = path[cur];
            }
            for (int ei = head[cur]; ei > 0; ei = next[ei]) {
                path[to[ei]] = Math.max(path[to[ei]], path[cur]);
                if (--indegree[to[ei]] == 0) {
                    queue[r++] = to[ei];
                }
            }
        }
        return ans;
    }

    private int index(int r, int c) {
        return r * col + c;
    }
}
