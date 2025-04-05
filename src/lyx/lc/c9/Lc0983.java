package lyx.lc.c9;

/**
 * 983. 最低票价
 */
public class Lc0983 {
    private static final int[] duration = {1,7,30};

    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n + 1];
        for (int i = n - 1, k; i >= 0; i--) {
            dp[i] = Integer.MAX_VALUE;
            k = i + 1;
            for (int j = 0; j < costs.length; j++) {
                while (k < days.length && days[k] < days[i] + duration[j]) {
                    k++;
                }
                dp[i] = Math.min(dp[i], costs[j] + dp[k]);
            }
        }
        return dp[0];
    }
}
