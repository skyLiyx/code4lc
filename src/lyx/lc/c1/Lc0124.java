package lyx.lc.c1;

import lyx.util.BinaryTree.TreeNode;

/**
 * 124. 二叉树中的最大路径和
 */
public class Lc0124 {
    public int maxPathSum(TreeNode root) {
        return f(root).maxPathSum;
    }

    private Info f(TreeNode root) {
        if (root == null) {
            return new Info(-1000, -1000);
        }
        Info leftInfo = f(root.left);
        Info rightInfo = f(root.right);
        // 当前最大的连续路径和
        // 要么来自左树，要么来自右树，要么是自己
        int pathSum = Math.max(
                Math.max(root.val, leftInfo.pathSum + root.val),
                Math.max(root.val, rightInfo.pathSum + root.val));
        // 当前最大路径和
        // 要么来自左树、要么来自右树、要么是一条连续路径、要么是左树+当前节点+右树的连续路径
        int maxPathSum = Math.max(
                Math.max(leftInfo.maxPathSum, rightInfo.maxPathSum),
                Math.max(pathSum, leftInfo.pathSum + root.val + rightInfo.pathSum));
        return new Info(maxPathSum, pathSum);
    }

    private static class Info {
        public int maxPathSum;
        public int pathSum;

        public Info(int maxPathSum, int pathSum) {
            this.maxPathSum = maxPathSum;
            this.pathSum = pathSum;
        }
    }
}
