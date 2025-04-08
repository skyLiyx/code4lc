package lyx.lc.c21;

/**
 * 2134. 最少交换次数来组合所有的 1 II
 */
public class Lc2134 {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int num : nums) {
            count += num;
        }
        if (count == 0 || count == n) {
            return 0;
        }
        int ans = count;
        int cnt = 0;
        for (int i = 0; i < count - 1; i++) {
            if (nums[i] == 0) {
                cnt++;
            }
        }
        for (int i = count - 1; i < n + count - 1; i++) {
            if (nums[i % n] == 0) {
                cnt++;
            }
            ans = Math.min(ans, cnt);
            if (nums[i - count + 1] == 0) {
                cnt--;
            }
        }
        return ans;
    }
}
