package com.lynx.lcp;

import java.util.*;

/**
 * LCP 35. 电动车游城市
 *
 * @apiNote 分层图最短路
 */
public class LCP35 {
    public int electricCarPlan(int[][] paths, int cnt, int start, int end, int[] charge) {
        int n = charge.length;
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] path : paths) {
            graph.get(path[0]).add(new int[]{path[1], path[2]});
            graph.get(path[1]).add(new int[]{path[0], path[2]});
        }
        // 城市&剩余电量
        int[][] distance = new int[n][cnt + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        boolean[][] visited = new boolean[n][cnt + 1];
        // 0: 城市
        // 1: 剩余电量
        // 2: 代价
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparing(a -> a[2]));
        heap.add(new int[]{start, 0, 0});
        distance[start][0] = 0;
        while (!heap.isEmpty()) {
            int[] record = heap.poll();
            int u = record[0];
            int power = record[1];
            int cost = record[2];
            if (u == end) {
                return cost;
            }
            if (visited[u][power]) {
                continue;
            }
            visited[u][power] = true;
            int newCost;
            if (power < cnt) {
                if (!visited[u][power + 1] && (newCost = cost + charge[u]) < distance[u][power + 1]) {
                    distance[u][power + 1] = newCost;
                    heap.add(new int[]{u, power + 1, newCost});
                }
            }
            for (int[] next : graph.get(u)) {
                int v = next[0];
                int w = next[1];
                int restPower = power - w;
                if (restPower >= 0 && !visited[v][restPower] && (newCost = cost + w) < distance[v][restPower]) {
                    distance[v][restPower] = newCost;
                    heap.add(new int[]{v, restPower, newCost});
                }
            }
        }
        return -1;
    }
}
