package com.lynx.lc.c9;

import com.lynx.util.TreeNode;

/**
 * 938.二叉搜索树的范围和
 */
public class Lc0938 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        return rangeSumBST(root.right, low, high)
                +
                root.val
                +
                rangeSumBST(root.left, low, high);
    }
}
