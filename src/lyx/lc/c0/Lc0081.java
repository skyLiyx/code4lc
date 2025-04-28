package lyx.lc.c0;

/**
 * 81. 搜索旋转排序数组 II
 */
public class Lc0081 {
    public boolean search(int[] nums, int target) {
        int n = nums.length, l = 0, r = n - 1, mid;
        while (l < r && nums[0] == nums[r]) {
            r--;
        }
        while (l < r) {
            mid = l + (r - l) / 2;
            if (nums[mid] >= nums[0]) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        int idx = n;
        if (nums[r] >= nums[0] && r + 1 < n) {
            idx = r + 1;
        }
        int ans = find(nums, 0, idx - 1, target);
        if (ans != -1) {
            return true;
        }
        ans = find(nums, idx, n - 1, target);
        return ans != -1;
    }

    private int find(int[] nums, int l, int r, int target) {
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[r] == target ? r : -1;
    }
}
