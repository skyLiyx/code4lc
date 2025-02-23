package com.lynx.lc.c6;

import com.lynx.util.TreeNode;

/**
 * 671.二叉树中第二小的节点
 */
public class Lc0671 {
    static int firstMin;
    public int findSecondMinimumValue(TreeNode root) {
        firstMin = root.val;
        return findMinimumValue(root);
    }

    private int findMinimumValue(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val == firstMin ? -1 : root.val;
        }
        if (root.val > firstMin) {
            return root.val;
        }
        int left = findMinimumValue(root.left);
        int right = findMinimumValue(root.right);
        if (left == -1 && right == -1) {
            return -1;
        }
        if (left == -1 || right == -1) {
            return left == -1 ? right : left;
        }
        return Math.min(left, right);
    }
}
