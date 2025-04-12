package lyx.lc.c3;

import java.util.ArrayList;
import java.util.List;

/**
 * 323. 无向图中连通分量的数目
 */
public class Lc0323 {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                ans++;
                dfs(graph, i, visited);
            }
        }
        return ans;
    }

    private void dfs(List<List<Integer>> graph, int i, boolean[] visited) {
        visited[i] = true;
        for (int next : graph.get(i)) {
            if (!visited[next]) {
                dfs(graph, next, visited);
            }
        }
    }
}
