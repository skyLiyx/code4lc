package com.lynx.lc.c6;

/**
 * 684. 冗余连接
 *
 * @apiNote 并查集
 */
public class Lc0684 {
    private final int[] father = new int[1001];

    private void build(int n) {
        for (int i = 1; i <= n; i++) {
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

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        build(n << 1);
        for (int[] edge : edges) {
            if (!union(edge[0], edge[1])) {
                return edge;
            }
        }
        return null;
    }
}
