package com.lynx.lc.c2;

import com.lynx.util.TreeNode;

/**
 * 270.最接近的二叉搜索树值
 */
public class Lc0270 {
    public int closestValue(TreeNode root, double target) {
        int lt = root.val;
        int gt = root.val;
        while (root != null) {
            if (target < root.val) {
                gt = root.val;
                root = root.left;
            } else if (target > root.val) {
                lt = root.val;
                root = root.right;
            } else {
                return root.val;
            }
        }
        return Math.abs(target - lt) <= Math.abs(target - gt) ? lt : gt;
    }
}
