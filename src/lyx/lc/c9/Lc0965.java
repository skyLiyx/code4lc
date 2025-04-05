package lyx.lc.c9;

import lyx.util.BinaryTree.TreeNode;

/**
 * 965.单值二叉树
 */
public class Lc0965 {
    public boolean isUnivalTree(TreeNode root) {
        // root != null
        return isUnivalTree(root, root.val);
    }

    private boolean isUnivalTree(TreeNode root, int value) {
        if (root == null) {
            return true;
        }
        if (root.val != value) {
            return false;
        }
        return isUnivalTree(root.left, value) && isUnivalTree(root.right, value);
    }
}
