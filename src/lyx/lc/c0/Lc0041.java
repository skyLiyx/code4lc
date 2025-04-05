package lyx.lc.c0;

/**
 * 41. 缺失的第一个正数
 */
public class Lc0041 {
    public int firstMissingPositive(int[] nums) {
        int l = 0;
        int r = nums.length;
        // 预期存在1~n的数字，对应在0~n-1范围内，然后通过遍历这个范围判断预期
        // l左边是排好的数字，r开始是与预期不符的垃圾区一直判断l位置的数，直到l与r相交：
        //   1、等于l+1，l++
        //   2、小于等于l或大于r，不是预期的数，放入垃圾区，降低预期，即r-1
        //   3、是预期的数，但是该数的位置已经存在该数，即重复的数字，放入垃圾区，降低预期，即r-1
        //   4、是预期的数，且可以交换到该数的下标处，直接交换
        // 最终l的位置就是排好的存在于数组中的数字
        while (l < r) {
            if (nums[l] == l + 1) {
                l++;
            } else if (nums[l] <= l || nums[l] > r || nums[l] == nums[nums[l] - 1]) {
                swap(nums, l, --r);
            } else {
                swap(nums, l, nums[l] - 1);
            }
        }
        return l + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
