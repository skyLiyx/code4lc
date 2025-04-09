package lyx.lc.c33;

/**
 * 3396. 使数组元素互不相同所需的最少操作次数
 *
 * @date 2025/04/08
 */
public class Lc3396 {
    public int minimumOperations(int[] nums) {
        int[] count = new int[101];
        int ans = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (count[nums[i]]++ > 0) {
                ans = i / 3 + 1;
                break;
            }
        }
        return ans;
    }
}
