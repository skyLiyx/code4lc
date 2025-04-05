package lyx.lc.c22;

/**
 * 2209.用地毯覆盖后的最少白色砖块
 *
 * @date 2025/02/21
 */
public class Lc2209 {
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        int n = floor.length();
        // dp[i][j]表示j条地毯覆盖前i个砖时白色砖块的最小数量
        int[][] dp = new int[n + 1][numCarpets + 1];
        for (int i = 1; i <= n; i++) {
            // 没有地毯时前i个砖中白色砖块的最小数量
            dp[i][0] = dp[i - 1][0] + (floor.charAt(i - 1) - '0');
            for (int j = 1; j <= numCarpets; j++) {
                // 两个选择，覆盖or不覆盖
                // 1.不覆盖，直接根据当前砖的颜色计算得出
                int c1 = dp[i - 1][j] + (floor.charAt(i - 1) - '0');
                // 2.覆盖，那么当前位置往前地毯长度的范围内，直接被覆盖，所以直接
                // 等于地毯长度覆盖范围外，剩余地毯覆盖后的白色砖块的最小数量
                int c2 = dp[Math.max(0, i - carpetLen)][j - 1];
                // 取两种情况的最小值
                dp[i][j] = Math.min(c1, c2);
            }
        }
        return dp[n][numCarpets];
    }
}
