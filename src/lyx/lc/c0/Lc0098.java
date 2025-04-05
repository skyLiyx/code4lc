package lyx.lc.c0;

import lyx.util.BinaryTree.TreeNode;

/**
 * 98.验证二叉搜索树
 */
public class Lc0098 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return process(root).isBST;
    }

    private ReturnData process(TreeNode node) {
        if (node == null) {
            return null;
        }
        ReturnData left = process(node.left);
        ReturnData right = process(node.right);
        int min = node.val;
        int max = node.val;
        if (left != null) {
            min = Math.min(min, left.min);
            max = Math.max(max, left.max);
        }
        if (right != null) {
            min = Math.min(min, right.min);
            max = Math.max(max, right.max);
        }
        boolean isBST = true;
        if (left != null && (!left.isBST || node.val <= left.max)) {
            isBST = false;
        }
        if (right != null && (!right.isBST || node.val >= right.min)) {
            isBST = false;
        }
        return new ReturnData(isBST, min, max);
    }

    static class ReturnData {
        public boolean isBST;
        public int min;
        public int max;

        public ReturnData(boolean isBST, int min, int max) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }
}
