package lyx.lc.c3;

import java.util.*;

/**
 * 310. 最小高度树
 */
public class Lc0310 {
    // TODO
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        int min = n;
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited, false);
            queue.clear();
            queue.add(i);
            int level = bfs(graph, visited, queue);
            if (level < min) {
                min = level;
                ans.clear();
                ans.add(i);
            } else if (level == min) {
                ans.add(i);
            }
        }
        return ans;
    }

    private int bfs(List<List<Integer>> graph, boolean[] visited, Queue<Integer> queue) {
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int next : graph.get(cur)) {
                    if (!visited[next]) {
                        queue.add(next);
                        visited[next] = true;
                    }
                }
            }
            level++;
        }
        return level;
    }
}