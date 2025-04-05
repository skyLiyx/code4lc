package lyx.lc.c3;

import lyx.util.BinaryTree.TreeNode;

/**
 * 333. 最大二叉搜索子树
 */
public class Lc0333 {
    public int largestBSTSubtree(TreeNode root) {
        return f(root).maxBSTSize;
    }

    private Info f(TreeNode root) {
        if (root == null) {
            return new Info(Long.MIN_VALUE, Long.MAX_VALUE, true, 0);
        }
        Info leftInfo = f(root.left);
        Info rightInfo = f(root.right);
        long max = Math.max(root.val, Math.max(leftInfo.max, rightInfo.max));
        long min = Math.min(root.val, Math.min(leftInfo.min, rightInfo.min));
        boolean isBst = leftInfo.isBST && rightInfo.isBST && root.val > leftInfo.max && root.val < rightInfo.min;
        int maxBstSize = isBst ? leftInfo.maxBSTSize + 1 + rightInfo.maxBSTSize : Math.max(leftInfo.maxBSTSize, rightInfo.maxBSTSize);
        return new Info(max, min, isBst, maxBstSize);
    }

    private static class Info {
        public long max;
        public long min;
        public boolean isBST;
        public int maxBSTSize;

        public Info(long max, long min, boolean isBST, int maxBSTSize) {
            this.max = max;
            this.min = min;
            this.isBST = isBST;
            this.maxBSTSize = maxBSTSize;
        }
    }
}
