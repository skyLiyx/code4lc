package lyx.lc.c33;

/**
 * 3392. 统计符合条件长度为 3 的子数组数目
 *
 * @date 2025/04/27
 */
public class Lc3392 {
    public int countSubarrays(int[] nums) {
        int ans = 0;
        for (int i = 2; i < nums.length; i++) {
            if ((nums[i] + nums[i - 2]) * 2 == nums[i - 1]) {
                ans++;
            }
        }
        return ans;
    }
}
