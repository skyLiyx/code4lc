package com.lynx.lc.c7;

import com.lynx.util.TreeNode;

/**
 * 700.二叉搜索树中的搜索
 */
public class Lc0700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        return searchBST(root.val > val ? root.left : root.right, val);
    }
}
