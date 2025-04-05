package lyx.lc.c6;

import lyx.util.BinaryTree.TreeNode;

/**
 * 669.修剪二叉搜索树
 */
public class Lc0669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        TreeNode l = trimBST(root.left, low, high);
        TreeNode r = trimBST(root.right, low, high);
        if (root.val < low || root.val > high) {
            return l == null ? r : l;
        }
        root.left = l;
        root.right = r;
        return root;
    }
}
