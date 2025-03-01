package com.lynx.lc.c5;

import com.lynx.util.BinaryTree.TreeNode;

/**
 * 572.另一棵树的子树
 */
public class Lc0572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        return isSame(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isSame(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null || node1.val != node2.val) {
            return false;
        }
        return isSame(node1.left, node2.left) && isSame(node1.right, node2.right);
    }
}
