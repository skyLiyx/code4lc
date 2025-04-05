package lyx.lc.c9;

/**
 * 922. 按奇偶排序数组 II
 */
public class Lc0922 {
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        for (int even = 0, odd = 1; even < n && odd < n; ) {
            if ((nums[n - 1] & 1) == 1) {
                swap(nums, odd, n - 1);
                odd += 2;
            } else {
                swap(nums, even, n - 1);
                even += 2;
            }
        }
        return nums;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
