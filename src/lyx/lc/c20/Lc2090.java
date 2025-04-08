package lyx.lc.c20;

import java.util.Arrays;

/**
 * 2090. 半径为 k 的子数组平均值
 */
public class Lc2090 {
    public int[] getAverages(int[] nums, int k) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        if ((k << 1) + 1 > nums.length) {
            return ans;
        }
        long sum = 0;
        for (int i = 0; i < (k << 1); i++) {
            sum += nums[i];
        }
        for (int i = (k << 1); i < nums.length; i++) {
            sum += nums[i];
            ans[i - k] = (int)(sum / ((k << 1) + 1));
            sum -= nums[i - (k << 1)];
        }
        return ans;
    }
}
