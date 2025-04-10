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
        TreeNode node = new TreeNode(root.val);
        invertTree(node, root.left, root.right);
        return node;
    }

    private void invertTree(TreeNode node, TreeNode left, TreeNode right) {
        if (left != null) {
            node.right = new TreeNode(left.val);
            invertTree(node.right, left.left, left.right);
        }
        if (right != null) {
            node.left = new TreeNode(right.val);
            invertTree(node.left, right.left, right.right);
        }
    }
}
