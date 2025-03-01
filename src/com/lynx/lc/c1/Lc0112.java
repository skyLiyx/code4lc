package com.lynx.lc.c1;

import com.lynx.util.BinaryTree.TreeNode;

/**
 * 112.路径总和
 */
public class Lc0112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            return true;
        }
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
}
