package com.lynx.lc.c13;

import com.lynx.util.TreeNode;

/**
 * 1379.找出克隆二叉树中的相同节点
 */
public class Lc1379 {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return find(cloned, target.val);
    }

    private TreeNode find(TreeNode cloned, int value) {
        if (cloned == null) {
            return null;
        }
        if (cloned.val == value) {
            return cloned;
        }
        TreeNode leftFound = find(cloned.left, value);
        if (leftFound != null) {
            return leftFound;
        }
        return find(cloned.right, value);
    }
}
