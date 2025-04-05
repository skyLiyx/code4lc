package lyx.lc.c0;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. 组合总和
 */
public class Lc0039 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(candidates, target, ans, new ArrayList<>(), 0);
        return ans;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> list, int cur) {
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = cur; i < candidates.length; i++) {
            list.add(candidates[i]);
            dfs(candidates, target - candidates[i], ans, list, i);
            list.remove(list.size() - 1);
        }
    }
}
