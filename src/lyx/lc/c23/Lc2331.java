package lyx.lc.c23;

import lyx.util.BinaryTree.TreeNode;

/**
 * 2331.计算布尔二叉树的值
 *
 * @date 2025/02/23
 */
public class Lc2331 {

    public boolean evaluateTree(TreeNode root) {
        return dfs(root) == 1;
    }

    private int dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }
        // 完全二叉树，不考虑其他情况
        int leftValue = dfs(root.left);
        int rightValue = dfs(root.right);
        if (root.val == 2) {
            return leftValue | rightValue;
        }
        return leftValue & rightValue;
    }

}
