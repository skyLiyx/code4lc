package com.lynx.lc.c1;

import com.lynx.util.TreeNode;

/**
 * 104.二叉树的最大深度
 */
public class Lc0104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
