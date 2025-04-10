package lyx.lc.c2;

/**
 * 283. 移动零
 *
 * @apiNote 双指针。
 * 由于要保持其他元素的相对顺序，所以不能维护末尾的零的边界，单纯的把0和这个边界交换。
 * 那么就只能维护非零数字的边界 l, 把不是零的数字全部移到这里面。每移动一次，边界右移，
 * 直到遍历完成。
 */
public class Lc0283 {
    public void moveZeroes(int[] nums) {
        int l = 0, r = 0, n = nums.length;
        while (r < n) {
            if (nums[r] != 0) {
                swap(nums, l, r);
                l++;
            }
            r++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
