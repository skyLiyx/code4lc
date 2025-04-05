package lyx.lc.c18;

/**
 * 1863. 找出所有子集的异或总和再求和
 *
 * @date 2025/04/05
 */
public class Lc1863 {
    public int subsetXORSum(int[] nums) {
        return dfs(nums, new int[nums.length], 0, 0);
    }

    public int dfs(int[] nums, int[] arr, int i, int size) {
        if (i == nums.length) {
            int sum = 0;
            for (int j = 0; j < size; j++) {
                sum ^= arr[j];
            }
            return sum;
        }
        int ans = dfs(nums, arr, i + 1, size);
        arr[size++] = nums[i];
        ans += dfs(nums, arr, i + 1, size);
        return ans;
    }
}
