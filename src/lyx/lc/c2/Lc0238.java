package lyx.lc.c2;

/**
 * 238. 除自身以外数组的乘积
 */
public class Lc0238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        prefix[0] = 1;
        int[] suffix = new int[n + 1];
        suffix[n] = 1;
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] * nums[i];
            suffix[n - 1 - i] = suffix[n - i] * nums[n - 1 - i];
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            // i之前的前缀乘积 * i后面的后缀乘积
            ans[i] = prefix[i] * suffix[i + 1];
        }
        return ans;
    }
}
