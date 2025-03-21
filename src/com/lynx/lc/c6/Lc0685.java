package com.lynx.lc.c6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 685. 冗余连接 II
 *
 * @apiNote 并查集
 */
public class Lc0685 {
    private final int[] father = new int[1001];
    private final int[] indegree = new int[1001];

    private void build(int n) {
        Arrays.fill(indegree, 0, n + 1, 0);
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
            father[fb] = fa;
            return true;
        } else {
            return false;
        }
    }

    private boolean isTreeAfterRemoveEdge(int[][] edges, int deleteIndex) {
        for (int i = 0; i < edges.length; i++) {
            if (i == deleteIndex) {
                continue;
            }
            if (!union(edges[i][0], edges[i][1])) {
                return false;
            }
        }
        return true;
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        build(n);
        for (int[] edge : edges) {
            ++indegree[edge[1]];
        }
        List<Integer> list = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            if (indegree[edges[i][1]] == 2) {
                list.add(i);
            }
        }
        // 不存在入度为2的点，那么有一个边连向了根节点
        if (list.isEmpty()) {
            for (int[] edge : edges) {
                if (!union(edge[0], edge[1])) {
                    return edge;
                }
            }
            return null;
        }
        // 存在入度为2的点，那么多余的边连接的是两个子节点
        if (isTreeAfterRemoveEdge(edges, list.get(0))) {
            return edges[list.get(0)];
        } else {
            return edges[list.get(1)];
        }
    }
}
