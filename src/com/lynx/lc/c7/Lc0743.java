package com.lynx.lc.c7;

import java.util.*;

/**
 * 743. 网络延迟时间
 *
 * @apiNote Dijkstra 算法
 * @see com.lynx.lc.c20.Lc2039
 */
public class Lc0743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : times) {
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        // 最短距离数组，初始化成最大值
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        boolean[] visited = new boolean[n + 1];

        // 小根堆
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparing(a -> a[1]));
        // 加入起始节点
        heap.add(new int[]{k, 0});
        distance[k] = 0;
        while (!heap.isEmpty()) {
            int cur = heap.poll()[0];
            if (!visited[cur]) {
                visited[cur] = true;
                for (int[] edge : graph.get(cur)) {
                    int to = edge[0];
                    int weight = edge[1];
                    if (!visited[to] && distance[cur] + weight < distance[to]) {
                        distance[to] = distance[cur] + weight;
                        heap.add(new int[] {to, distance[cur] + weight});
                    }
                }
            }
        }
        int ans = -1;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                return -1;
            }
            ans = Math.max(ans, distance[i]);
        }
        return ans;
    }
}
