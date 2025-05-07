package lyx.lc.c29;

/**
 * 2962. 统计最大元素出现至少 K 次的子数组
 *
 * @date 2025/04/29
 */
public class Lc2962 {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
        }
        long ans = 0;
        for (int l = 0, r = 0, count = 0; r < n; r++) {
            if (nums[r] == max) {
                count++;
            }
            while (count == k) {
                if (nums[l++] == max) {
                    count--;
                }
            }
            // 前面所有的都合法
            ans += l;
        }
        return ans;
    }
}
