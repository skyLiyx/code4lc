package com.lynx.lc.c0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90.子集 II
 *
 * @see Lc0078
 */
public class Lc0090 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int[] arr = new int[nums.length];
        recur(ans, arr, nums, 0, 0);
        return ans;
    }

    private void recur(List<List<Integer>> ans, int[] arr, int[] nums, int i, int size) {
        if (i == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                list.add(arr[j]);
            }
            ans.add(list);
            return;
        }
        // 下一个数的位置
        int j = i + 1;
        while (j < nums.length && nums[j] == nums[i]) {
            j++;
        }
        // 不要当前数
        recur(ans, arr, nums, j, size);
        // 要1到(j-i)个数量的当前数
        for (int k = 0; k < j - i; k++) {
            arr[size++] = nums[i];
            recur(ans, arr, nums, j, size);
        }
    }
}
