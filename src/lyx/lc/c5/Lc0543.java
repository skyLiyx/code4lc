package lyx.lc.c5;

import lyx.util.BinaryTree.TreeNode;

/**
 * 543.二叉树的直径
 */
public class Lc0543 {
    public int diameterOfBinaryTree(TreeNode root) {
        return process(root).diameter;
    }

    private ReturnData process(TreeNode root) {
        if (root == null) {
            return new ReturnData(0, 0);
        }
        ReturnData leftData = process(root.left);
        ReturnData rightData = process(root.right);
        int depth = Math.max(leftData.depth, rightData.depth) + 1;
        int diameter = Math.max(leftData.diameter, rightData.diameter);
        diameter = Math.max(diameter, leftData.depth + rightData.depth);
        return new ReturnData(depth, diameter);
    }

    static class ReturnData {
        int depth;
        int diameter;

        public ReturnData(int depth, int diameter) {
            this.depth = depth;
            this.diameter = diameter;
        }
    }
}
