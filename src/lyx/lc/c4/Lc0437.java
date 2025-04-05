package lyx.lc.c4;

import lyx.util.BinaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 437. 路径总和 III
 */
public class Lc0437 {
    private static final Map<Long, Integer> prefixSumMap = new HashMap<>();

    private static int ans;

    public int pathSum(TreeNode root, int targetSum) {
        prefixSumMap.clear();
        prefixSumMap.put(0L, 1);
        ans = 0;
        f(root, targetSum, 0);
        return ans;
    }

    private void f(TreeNode root, int targetSum, long prefixSum) {
        if (root == null) {
            return;
        }
        prefixSum += root.val;
        ans += prefixSumMap.getOrDefault(prefixSum - targetSum, 0);
        prefixSumMap.put(prefixSum, prefixSumMap.getOrDefault(prefixSum, 0) + 1);
        f(root.left, targetSum, prefixSum);
        f(root.right, targetSum, prefixSum);
        // 当前节点退出，不能再参与路径
        prefixSumMap.put(prefixSum, prefixSumMap.getOrDefault(prefixSum, 1) - 1);
    }
}
