package lyx.lc.c1;

/**
 * 189. 轮转数组
 */
public class Lc0189 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        // [1,2,3,4,5,6,7]
        reverse(nums, 0, n - 1);
        // [7,6,5,4,3,2,1]
        reverse(nums, 0, k - 1);
        // [5,6,7,4,3,2,1]
        reverse(nums, k, n - 1);
        // [5,6,7,1,2,3,4]
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}
