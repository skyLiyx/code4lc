package com.lynx.lc.c0;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 47.全排列 II
 *
 * @see Lc0046
 */
public class Lc0047 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        recur(ans, nums, 0);
        return ans;
    }

    private void recur(List<List<Integer>> ans, int[] nums, int i) {
        if (i == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            ans.add(list);
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int j = i; j < nums.length; j++) {
            // 只有这个数没有来过当前位置，才交换
            if (!set.contains(nums[j])) {
                set.add(nums[j]);
                swap(nums, i, j);
                recur(ans, nums, i + 1);
                swap(nums, i, j);
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
