package com.lynx.lc.c5;

import com.lynx.lc.c7.Lc0783;
import com.lynx.util.TreeNode;

/**
 * 530.二叉搜索树的最小绝对差
 *
 * @apiNote 本题与783相同
 * @see Lc0783
 */
public class Lc0530 {
    public int getMinimumDifference(TreeNode root) {
        return process(root).minDiff;
    }

    private ReturnData process(TreeNode root) {
        if (root == null) {
            return null;
        }
        ReturnData leftData = process(root.left);
        ReturnData rightData = process(root.right);
        int minDiff = Integer.MAX_VALUE;
        int minValue;
        int maxValue;
        if (leftData == null && rightData == null) {
            minValue = root.val;
            maxValue = root.val;
        } else if (leftData == null) {
            minDiff = Math.min(rightData.minValue - root.val, rightData.minDiff);
            minValue = root.val;
            maxValue = rightData.maxValue;
        } else if (rightData == null) {
            minDiff = Math.min(root.val - leftData.maxValue, leftData.minDiff);
            minValue = leftData.minValue;
            maxValue = root.val;
        } else {
            minDiff = Math.min(leftData.minDiff, rightData.minDiff);
            minDiff = Math.min(root.val - leftData.maxValue, minDiff);
            minDiff = Math.min(rightData.minValue - root.val, minDiff);
            minValue = leftData.minValue;
            maxValue = rightData.maxValue;
        }
        return new ReturnData(minDiff, maxValue, minValue);
    }

    static class ReturnData {
        int minDiff;
        int maxValue;
        int minValue;

        public ReturnData(int minDiff, int maxValue, int minValue) {
            this.minDiff = minDiff;
            this.maxValue = maxValue;
            this.minValue = minValue;
        }
    }
}
