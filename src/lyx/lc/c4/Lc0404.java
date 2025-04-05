package lyx.lc.c4;

import lyx.util.BinaryTree.TreeNode;

/**
 * 404.左叶子之和
 */
public class Lc0404 {
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root, false);
    }

    private int sumOfLeftLeaves(TreeNode node, boolean left) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null && left) {
            // 是叶子节点，且是左边的
            return node.val;
        }
        return sumOfLeftLeaves(node.left, true) + sumOfLeftLeaves(node.right, false);
    }
}
