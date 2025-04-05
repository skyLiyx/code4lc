package lyx.lc.c6;

/**
 * 698. 划分为k个相等的子集
 *
 * @apiNote 状压DP
 * @see lyx.lc.c4.Lc0473
 */
public class Lc0698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        int n = nums.length;
        int[] dp = new int[1 << n];
        return f(nums, sum / k, k, sum / k, (1 << n) - 1, dp);
    }
    /**
     *
     * @param arr    数组
     * @param limit  每个子集的和
     * @param no     剩余子集个数
     * @param rest   当前子集达成要求的剩余大小
     * @param status 数组中剩余可选下标
     * @param dp     缓存
     */
    private boolean f(int[] arr, int limit, int no, int rest, int status, int[] dp) {
        if (no == 0) {
            return status == 0; // 所有元素都用光
        }
        if (dp[status] != 0) {
            return dp[status] == 1;
        }
        boolean ans = false;
        for (int i = 0; i < arr.length; i++) {
            if ((status & (1 << i)) != 0 && arr[i] <= rest) {
                if (arr[i] == rest) {
                    ans = f(arr, limit, no - 1, limit, status ^ (1 << i), dp);
                } else {
                    ans = f(arr, limit, no, rest - arr[i], status ^ (1 << i), dp);
                }
                if (ans) {
                    break;
                }
            }
        }
        dp[status] = ans ? 1 : -1;
        return ans;
    }
}
