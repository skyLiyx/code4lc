package lyx.lc.c2;

import lyx.util.BinaryTree.TreeNode;

/**
 * 226.翻转二叉树
 */
public class Lc0226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}
