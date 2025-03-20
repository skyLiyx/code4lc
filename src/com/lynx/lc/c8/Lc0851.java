package com.lynx.lc.c8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 851. 喧闹和富有
 *
 * @apiNote 拓扑排序
 */
public class Lc0851 {
    private static final int MAXN = 501;
    private final int[] indegree = new int[MAXN];
    private final int[] queue = new int[MAXN];

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        Arrays.fill(indegree, 0, n + 1, 0);
        int[] ans = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            ans[i] = i;
        }
        for (int[] r : richer) {
            int from = r[0];
            int to = r[1];
            graph.get(from).add(to);
            indegree[to]++;
        }
        int l = 0, r = 0;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue[r++] = i;
            }
        }
        while (l < r) {
            int cur = queue[l++];
            for (int to : graph.get(cur)) {
                if (quiet[ans[cur]] < quiet[ans[to]]) {
                    ans[to] = ans[cur];
                }
                if (--indegree[to] == 0) {
                    queue[r++] = to;
                }
            }
        }
        return ans;
    }
}
