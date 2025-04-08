package lyx.lc.c11;

/**
 * 1176. 健身计划评估
 */
public class Lc1176 {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < k - 1; i++) {
            sum += calories[i];
        }
        for (int i = k - 1; i < calories.length; i++) {
            sum += calories[i];
            if (sum < lower) {
                ans--;
            }
            if (sum > upper) {
                ans++;
            }
            sum -= calories[i - k + 1];
        }
        return ans;
    }
}
