package lyx.lc.c18;

/**
 * 1852. 每个子数组的数字种类数
 */
public class Lc1852 {
    public int[] distinctNumbers(int[] nums, int k) {
        int[] count = new int[100001];
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int cnt = 0;
        for (int i = 0; i < k - 1; i++) {
            if (count[nums[i]]++ == 0) {
                cnt++;
            }
        }
        for (int i = k - 1; i < n; i++) {
            if (count[nums[i]]++ == 0) {
                cnt++;
            }
            ans[i - k + 1] = cnt;
            if (--count[nums[i - k + 1]] == 0) {
                cnt--;
            }
        }
        return ans;
    }
}
