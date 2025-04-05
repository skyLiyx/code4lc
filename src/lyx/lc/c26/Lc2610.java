package lyx.lc.c26;

import java.util.ArrayList;
import java.util.List;

/**
 * 2610. 转换二维数组
 *
 * @date 2025/03/19
 */
public class Lc2610 {
    public List<List<Integer>> findMatrix(int[] nums) {
        int n = nums.length;
        int[] count = new int[n + 1];
        for (int num : nums) {
            ++count[num];
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                if (ans.size() <= j) {
                    ans.add(new ArrayList<>());
                }
                ans.get(j).add(i);
            }
        }
        return ans;
    }
}
