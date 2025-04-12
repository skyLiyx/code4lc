package lyx.lc.c21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2101. 引爆最多的炸弹
 */
public class Lc2101 {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0, x, y, r; i < n; i++) {
            List<Integer> nexts = new ArrayList<>();
            x = bombs[i][0];
            y = bombs[i][1];
            r = bombs[i][2];
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                long dx = x - bombs[j][0];
                long dy = y - bombs[j][1];
                if (dx * dx + dy * dy <= (long) r * r) {
                    nexts.add(j);
                }
            }
            graph.add(nexts);
        }
        boolean[] visited = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited, false);
            ans = Math.max(ans, dfs(graph, visited, i));
        }
        return ans;
    }

    private int dfs(List<List<Integer>> graph, boolean[] visited, int i) {
        visited[i] = true;
        int cnt = 1;
        for (int next : graph.get(i)) {
            if (!visited[next]) {
                cnt += dfs(graph, visited, next);
            }
        }
        return cnt;
    }
}
