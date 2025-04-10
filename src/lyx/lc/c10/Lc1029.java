package lyx.lc.c10;

import java.util.Arrays;

/**
 * 1029. 两地调度
 */
public class Lc1029 {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length >> 1;
        // 按照去AB两地的代价差值排序
        // 差值越小，说明去A划算，相反，去B划算
        Arrays.sort(costs, (c1, c2) -> (c1[0] - c1[1]) - (c2[0] - c2[1]));
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += costs[i][0];
        }
        for (int i = n; i < (n << 1); i++) {
            ans += costs[i][1];
        }
        return ans;
    }
}
