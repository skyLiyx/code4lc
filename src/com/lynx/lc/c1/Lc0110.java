package com.lynx.lc.c1;

import com.lynx.util.BinaryTree.TreeNode;

/**
 * 110.平衡二叉树
 */
public class Lc0110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return process(root).isBalanced;
    }

    private ReturnData process(TreeNode node) {
        if (node == null) {
            return new ReturnData(true, 0);
        }
        ReturnData left = process(node.left);
        ReturnData right = process(node.right);
        boolean isBalanced = left.isBalanced && right.isBalanced && Math.abs(left.height - right.height) < 2;
        int height = Math.max(left.height, right.height) + 1;
        return new ReturnData(isBalanced, height);
    }

    static class ReturnData {
        public boolean isBalanced;
        public int height;

        public ReturnData(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
}
