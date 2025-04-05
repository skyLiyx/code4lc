package lyx.lc.c5;

import lyx.util.BinaryTree.TreeNode;

/**
 * 563.二叉树的坡度
 */
public class Lc0563 {
    public int findTilt(TreeNode root) {
        return process(root).tilt;
    }

    private ReturnData process(TreeNode root) {
        if (root == null) {
            return new ReturnData(0, 0);
        }
        ReturnData leftData = process(root.left);
        ReturnData rightData = process(root.right);
        int sum = leftData.sum + rightData.sum + root.val;
        int tilt = leftData.tilt + rightData.tilt + Math.abs(leftData.sum - rightData.sum);
        return new ReturnData(sum, tilt);
    }

    static class ReturnData {
        int sum;  // 节点之和
        int tilt; // 树的坡度

        public ReturnData(int sum, int tilt) {
            this.sum = sum;
            this.tilt = tilt;
        }
    }
}
