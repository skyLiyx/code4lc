package lyx.lc.c11;

import java.util.Arrays;

/**
 * 1168. 水资源分配优化
 *
 * @apiNote 最小生成树
 */
public class Lc1168 {
    private static final int MAXN = 10001;

    private static int cnt;

    private static final int[][] edges = new int[MAXN << 1][3];

    private static final int[] father = new int[MAXN];

    private void build(int n) {
        cnt = 0;
        for (int i = 0; i <= n; i++) {
            father[i] = i;
        }
    }

    private int find(int i) {
        if (i != father[i]) {
            father[i] = find(father[i]);
        }
        return father[i];
    }

    private boolean union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) {
            father[fa] = fb;
            return true;
        } else {
            return false;
        }
    }

    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        // 构造一个虚拟点，用其到各个点的权值来替代每个点的代价
        build(n);
        for (int i = 0; i < n; i++, cnt++) {
            edges[cnt][0] = 0;
            edges[cnt][1] = i + 1;
            edges[cnt][2] = wells[i];
        }
        for (int i = 0; i < pipes.length; i++, cnt++) {
            edges[cnt][0] = pipes[i][0];
            edges[cnt][1] = pipes[i][1];
            edges[cnt][2] = pipes[i][2];
        }
        int ans = 0;
        Arrays.sort(edges, 0, cnt, (e1, e2) -> e1[2] - e2[2]);
        for (int i = 0; i < cnt; i++) {
            if (union(edges[i][0], edges[i][1])) {
                ans += edges[i][2];
            }
        }
        return ans;
    }
}
