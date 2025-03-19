package com.lynx.lc.c24;

import java.util.Arrays;

/**
 * 2421. 好路径的数目
 *
 * @apiNote 并查集
 */
public class Lc2421 {
    private static final int MAXN = 100001;

    private final int[] father = new int[MAXN];

    // 每个集合最大值的个数
    private final int[] maxCount = new int[MAXN];

    private void build(int n) {
        for (int i = 0; i < n; i++) {
            father[i] = i;
            maxCount[i] = 1;
        }
    }

    private int find(int i) {
        if (i != father[i]) father[i] = find(father[i]);
        return father[i];
    }

    private int union(int a, int b, int[] vals) {
        int fa = find(a);
        int fb = find(b);
        int path = 0;
        if (fa != fb) {
            // 以最大值作为代表节点
            if (vals[fa] < vals[fb]) {
                father[fa] = fb;
            } else if (vals[fa] > vals[fb]) {
                father[fb] = fa;
            } else {
                // 两个集合最大值一样的时候，产生好路径
                path = maxCount[fa] * maxCount[fb];
                father[fa] = fb;
                maxCount[fb] += maxCount[fa];
            }
        }
        return path;
    }

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;
        build(n);
        Arrays.sort(edges, (a, b) -> Math.max(vals[a[0]], vals[a[1]]) - Math.max(vals[b[0]], vals[b[1]]));
        int ans = n;
        for (int[] edge : edges) {
            ans += union(edge[0], edge[1], vals);
        }
        return ans;
    }
}
