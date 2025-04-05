package lyx.lc.c0;

import java.util.ArrayList;
import java.util.List;

/**
 * 78.子集
 *
 * @see Lc0090
 */
public class Lc0078 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
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
        // 不要当前数
        recur(ans, arr, nums, i + 1, size);
        // 要当前数
        arr[size++] = nums[i];
        recur(ans, arr, nums, i + 1, size);
    }
}
