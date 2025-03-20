package com.lynx.lc.c20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2050. 并行课程 III
 *
 * @apiNote 拓扑排序
 */
public class Lc2050 {
    private static final int MAXN = 50001;
    private final int[] indegree = new int[MAXN];
    private final int[] queue = new int[MAXN];

    public int minimumTime(int n, int[][] relations, int[] time) {
        Arrays.fill(indegree, 0, n + 1, 0);
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] r : relations) {
            int from = r[0];
            int to = r[1];
            graph.get(from).add(to);
            indegree[to]++;
        }
        int l = 0, r = 0;
        // 第i个课程完成需要的时间
        int[] cost = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue[r++] = i;
            }
        }
        int ans = 0;
        while (l < r) {
            int cur = queue[l++];
            cost[cur] += time[cur - 1];
            ans = Math.max(ans, cost[cur]);
            for (int next : graph.get(cur)) {
                cost[next] = Math.max(cost[next], cost[cur]);
                if (--indegree[next] == 0) {
                    queue[r++] = next;
                }
            }
        }
        return ans;
    }
}
