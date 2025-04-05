package lyx.lc.c1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 163. 缺失的区间
 */
public class Lc0163 {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        if (n == 0) {
            ans.add(Arrays.asList(lower, upper));
            return ans;
        }
        if (nums[0] != lower) {
            ans.add(Arrays.asList(lower, nums[0] - 1));
        }
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                ans.add(Arrays.asList(nums[i - 1] + 1, nums[i] - 1));
            }
        }
        if (nums[n - 1] != upper) {
            ans.add(Arrays.asList(nums[n - 1] + 1, upper));
        }
        return ans;
    }
}
