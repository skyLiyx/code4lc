package lyx.lc.c26;

/**
 * 2680. 最大或值
 *
 * @date 2025/03/21
 */
public class Lc2680 {
    public long maximumOr(int[] nums, int k) {
        int or = 0;
        int fix = 0;
        for (int num : nums) {
            fix |= or & num; // 记录1的位
            or |= num;
        }
        long ans = 0;
        for (int num : nums) {
            ans = Math.max(ans, (or ^ num) | fix | ((long)num << k));
        }
        return ans;
    }
}
