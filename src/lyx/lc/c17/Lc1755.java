package lyx.lc.c17;

import java.util.Arrays;

/**
 * 1755. 最接近目标值的子序列和
 *
 * @apiNote 双向广搜
 */
public class Lc1755 {
    private static final int MAXN = 1 << 20;

    private final int[] lsum = new int[MAXN];
    private final int[] rsum = new int[MAXN];
    private int size;

    public int minAbsDifference(int[] nums, int goal) {
        int n = nums.length;
        int pos = 0;
        int neg = 0;
        for (int num : nums) {
            if (num > 0) {
                pos += num;
            } else {
                neg += num;
            }
        }
        if (pos < goal) {
            return Math.abs(pos - goal);
        }
        if (neg > goal) {
            return Math.abs(neg - goal);
        }
        Arrays.sort(nums);
        size = 0;
        collect(nums, 0, n >> 1, 0, lsum);
        int lsize = size;
        size = 0;
        collect(nums, n >> 1, n, 0, rsum);
        int rsize = size;
        Arrays.sort(lsum, 0, lsize);
        Arrays.sort(rsum, 0, rsize);
        int ans = Integer.MAX_VALUE;
        for (int i = 0, j = rsize - 1; i < lsize; i++) {
            while (j > 0 && Math.abs(goal - lsum[i] - rsum[j - 1]) <= Math.abs(goal - lsum[i] - rsum[j])) {
                j--;
            }
            ans = Math.min(ans, Math.abs(goal - lsum[i] - rsum[j]));
        }
        return ans;
    }

    private void collect(int[] nums, int i, int end, int s, int[] sum) {
        if (i == end) {
            sum[size++] = s;
        } else {
            int j = i + 1;
            while (j < end && nums[j] == nums[i]) {
                j++;
            }
            for (int k = 0; k <= j - i; k++) {
                collect(nums, j, end, s + k * nums[i], sum);
            }
        }
    }
}
