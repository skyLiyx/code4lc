package com.lynx.lc.c1;

import com.lynx.util.BinaryTree.TreeNode;

/**
 * 100.相同的树
 */
public class Lc0100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p != null && q != null && p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(q.right, q.right);
        } else {
            return false;
        }
    }
}
