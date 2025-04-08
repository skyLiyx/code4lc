package lyx.lc.c14;

/**
 * 1423. 可获得的最大点数
 */
public class Lc1423 {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }
        int ans = sum;
        for (int i = k - 1; i >= 0; i--) {
            sum -= cardPoints[i];
            sum += cardPoints[cardPoints.length - k + i];
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
