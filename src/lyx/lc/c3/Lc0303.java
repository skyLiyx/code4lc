package lyx.lc.c3;

/**
 * 303. 区域和检索 - 数组不可变
 */
public class Lc0303 {

    public static class NumArray {

        private final int[] sum;

        public NumArray(int[] nums) {
            sum = new int[nums.length + 1];
            for (int i = 1; i < sum.length; i++) {
                sum[i] = sum[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int left, int right) {
            return sum[right + 1] - sum[left];
        }
    }
}
