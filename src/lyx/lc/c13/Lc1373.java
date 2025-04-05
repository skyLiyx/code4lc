package lyx.lc.c13;

import lyx.util.BinaryTree.TreeNode;

/**
 * 1373. 二叉搜索子树的最大键值和
 */
public class Lc1373 {
    public int maxSumBST(TreeNode root) {
        return f(root).maxBSTSum;
    }
    
    private Info f(TreeNode root) {
        if (root == null) {
            return new Info(Integer.MIN_VALUE, Integer.MAX_VALUE, true, 0, 0);
        }
        Info leftInfo = f(root.left);
        Info rightInfo = f(root.right);
        int max = Math.max(root.val, Math.max(leftInfo.max, rightInfo.max));
        int min = Math.min(root.val, Math.min(leftInfo.min, rightInfo.min));
        boolean isBST = leftInfo.isBST && rightInfo.isBST && root.val > leftInfo.max && root.val < rightInfo.min;
        int sum = leftInfo.sum + root.val + rightInfo.sum;
        int maxBSTSum = Math.max(leftInfo.maxBSTSum, rightInfo.maxBSTSum);
        if (isBST) {
            maxBSTSum = Math.max(maxBSTSum, sum);
        }
        return new Info(max, min, isBST, sum, maxBSTSum);
    }

    private static class Info {
        public int max;
        public int min;
        public boolean isBST;
        public int sum;
        public int maxBSTSum;

        public Info(int max, int min, boolean isBST, int sum, int maxBSTSum) {
            this.max = max;
            this.min = min;
            this.isBST = isBST;
            this.sum = sum;
            this.maxBSTSum = maxBSTSum;
        }
    }
}
