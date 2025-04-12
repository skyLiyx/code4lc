package lyx.lc.c5;

/**
 * 547. 省份数量
 */
public class Lc00547 {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int ans = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                ans++;
                dfs(isConnected, i, visited);
            }
        }
        return ans;
    }

    private void dfs(int[][] isConnected, int i, boolean[] visited) {
        visited[i] = true;
        for (int j = 0; j < isConnected.length; j++) {
            if (!visited[j] && isConnected[i][j] == 1) {
                dfs(isConnected, j, visited);
            }
        }
    }
}
