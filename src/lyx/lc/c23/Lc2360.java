package lyx.lc.c23;

/**
 * 2360. 图中的最长环
 *
 * @date 2025/03/29
 */
public class Lc2360 {

    public int longestCycle(int[] edges) {
        int n = edges.length;
        int ans = -1;
        int currentTime = 1;
        int[] visitTime = new int[n];
        for (int i = 0, x, startTime; i < n; i++) {
            x = i;
            startTime = currentTime;
            while (x != -1 && visitTime[x] == 0) {
                // 遇到出度为0的节点 或 第二次遇到某个节点时退出循环
                visitTime[x] = currentTime++;
                x = edges[x];
            }
            if (x != -1 && visitTime[x] >= startTime) {
                // 第二次遇到x节点，存在环
                ans = Math.max(ans, currentTime - visitTime[x]);
            }
        }
        return ans;
    }
}
