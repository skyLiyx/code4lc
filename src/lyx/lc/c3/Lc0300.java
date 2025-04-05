package lyx.lc.c3;

/**
 * 300. 最长递增子序列
 */
public class Lc0300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] end = new int[n];
        int len = 0;
        for (int num : nums) {
            int find = bs(end, len, num);
            if (find == -1) {
                end[len++] = num;
            } else {
                end[find] = num;
            }
        }
        return len;
    }

    private int bs(int[] end, int len, int target) {
        int l = 0, r = len - 1, m;
        int ans = -1;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (end[m] >= target) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }
}
