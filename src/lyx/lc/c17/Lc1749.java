package lyx.lc.c17;

/**
 * 1749. 任意子数组和的绝对值的最大值
 */
public class Lc1749 {
    public int maxAbsoluteSum(int[] nums) {
        int sum = 0, max = 0, min = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, sum);
            min = Math.min(min, sum);
        }
        return max - min;
    }
}
