package lyx.lc.c0;

import java.util.ArrayList;
import java.util.List;

/**
 * 46.全排列
 *
 * @see Lc0047
 */
public class Lc0046 {
    public List<List<Integer>> permute(int[] nums) {
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
        // 将当前下标与后面的下标依次互换，然后递归处理后面的数
        for (int j = i; j < nums.length; j++) {
            swap(nums, i, j);
            recur(ans, nums, i + 1);
            swap(nums, i, j);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
