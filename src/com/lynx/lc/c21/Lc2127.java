package com.lynx.lc.c21;

/**
 * 2127. 参加会议的最多员工数
 *
 * @apiNote 拓扑排序
 */
public class Lc2127 {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int[] indegree = new int[n];
        for (int f : favorite) {
            indegree[f]++;
        }
        int[] queue = new int[n];
        int l = 0, r = 0;
        // 用于统计每个节点的最大长度
        int[] deep = new int[n];
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue[r++] = i;
            }
        }
        while (l < r) {
            int cur = queue[l++];
            int to = favorite[cur];
            // 更新最大长度
            deep[to] = Math.max(deep[to], deep[cur] + 1);
            if (--indegree[to] == 0) {
                queue[r++] = to;
            }
        }
        // 到这里为止，除了环上节点以外，其他节点都被删除了
        int sumOfSmallRings = 0;
        int bigRings = 0;
        for (int i = 0; i < n; i++) {
            if (indegree[i] != 0) {
                indegree[i] = 0;
                int ringSize = 1;
                for (int j = favorite[i]; j != i; j = favorite[j]) {
                    indegree[j] = 0;
                    ringSize++;
                }
                if (ringSize == 2) {
                    // 如果是小环，那么可以选择两个节点和他们的最长路径点
                    // 如果是森林中多个小环，那么他们可以合计
                    sumOfSmallRings += deep[i] + deep[favorite[i]] + 2;
                } else {
                    // 如果是大环，那么只能选择环上的节点
                    // 如果是森林中多个大环，只能选择一个
                    bigRings = Math.max(bigRings, ringSize);
                }
            }
        }
        return Math.max(sumOfSmallRings, bigRings);
    }
}
