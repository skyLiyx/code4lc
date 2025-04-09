package lyx.lc.c4;

/**
 * 456. 132 模式
 */
public class Lc0456 {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int[] stack = new int[n];
        int size = 0;
        int k = Integer.MIN_VALUE;
        for (int p = n - 1; p >= 0; p--) {
            if (nums[p] < k) {
                return true;
            }
            while (size > 0 && nums[p] > nums[stack[size - 1]]) {
                k = Math.max(k, nums[stack[--size]]);
            }
            stack[size++] = p;
        }
        return false;
    }
}
