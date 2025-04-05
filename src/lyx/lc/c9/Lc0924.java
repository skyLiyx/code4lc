package lyx.lc.c9;

import java.util.Arrays;

/**
 * 924. 尽量减少恶意软件的传播
 *
 * @apiNote 并查集
 */
public class Lc0924 {
    private static final int MAXN = 301;

    private final int[] father = new int[MAXN];

    private final int[] size = new int[MAXN];

    private final int[] infect = new int[MAXN];

    private void build(int n, int[] initial) {
        for (int i = 0; i < n; i++) {
            father[i] = i;
            size[i] = 1;
            infect[i] = 0;
        }
        for (int i : initial) {
            infect[i] = 1;
        }
    }

    private int find(int i) {
        if (i != father[i]) {
            father[i] = find(father[i]);
        }
        return father[i];
    }

    private void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) {
            father[fa] = fb;
            size[fb] += size[fa];
            infect[fb] += infect[fa];
        }
    }

    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n = graph.length;
        build(n, initial);
        // 先把所有相连的节点合并
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        // 然后统计每个集合的感染点数量
        Arrays.sort(initial);
        int ans = -1;
        int max = 0;
        for (int i : initial) {
            int fa = find(i);
            // 只有当前集合只有一个感染点的，才能被删除
            if (infect[fa] == 1 && size[fa] > max) {
                max = size[fa];
                ans = i;
            }
        }
        return ans == -1 ? initial[0] : ans;
    }
}