package lyx.lc.c2;

import lyx.util.BinaryTree.TreeNode;

/**
 * 222.完全二叉树的节点个数
 */
public class Lc0222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLevel = countLevel(root.left);
        int rightLevel = countLevel(root.right);
        if (leftLevel == rightLevel) {
            // 左边一定是满二叉树
            return (1 << leftLevel) + countNodes(root.right);
        } else {
            // 右边一定是满二叉树
            return countNodes(root.left) + (1 << rightLevel);
        }
    }

    private int countLevel(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(countLevel(node.left), countLevel(node.right)) + 1;
    }
}
