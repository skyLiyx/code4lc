package lyx.lc.c1;

import java.util.List;

/**
 * 120.三角形最小路径和
 */
public class Lc0120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int levels = triangle.size();
        int[][] dp = new int[levels][];
        for (int i = 0; i < levels; i++) {
            dp[i] = new int[triangle.get(i).size()];
            if (i == levels - 1) {
                for (int j = 0; j < triangle.get(i).size(); j++) {
                    dp[i][j] = triangle.get(i).get(j);
                }
            }
        }
        for (int i = levels - 2; i >= 0; i--) {
            for (int j = triangle.get(i).size() - 1; j >= 0; j--) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }
        return dp[0][0];
    }

    /**
     * 暴力递归版本。
     */
    private int recur(List<List<Integer>> triangle, int level, int index) {
        if (level == triangle.size() - 1) {
            return triangle.get(level).get(index);
        }
        int left = recur(triangle, level + 1, index);
        int right = recur(triangle, level + 1, index + 1);
        return triangle.get(level).get(index) + Math.min(left, right);
    }
}
