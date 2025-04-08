package lyx.lc.c26;

/**
 * 2653. 滑动子数组的美丽值
 */
public class Lc2653 {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int[] count = new int[101];
        for (int i = 0; i < k - 1; i++) {
            count[nums[i] + 50]++;
        }
        for (int i = k - 1; i < n; i++) {
            count[nums[i] + 50]++;
            int cnt = 0;
            for (int j = 0; j < 50; j++) {
                cnt += count[j];
                if (cnt >= x) {
                    ans[i - k + 1] = j - 50;
                    break;
                }
            }
            count[nums[i - k + 1] + 50]--;
        }
        return ans;
    }
}
