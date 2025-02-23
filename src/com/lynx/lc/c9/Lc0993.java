package com.lynx.lc.c9;

import com.lynx.util.TreeNode;

/**
 * 993.二叉树的堂兄弟节点
 */
public class Lc0993 {
    public boolean isCousins(TreeNode root, int x, int y) {
        ReturnData r1 = process(root, null, 1, x);
        ReturnData r2 = process(root, null, 1, y);
        return r1 != null && r2 != null && r1.father != r2.father && r1.level == r2.level && r1.level != 0;
    }

    private ReturnData process(TreeNode root, TreeNode father, int level, int value) {
        if (root == null) {
            return null;
        }
        if (root.val == value) {
            return new ReturnData(level, father);
        }
        ReturnData leftData = process(root.left, root, level + 1, value);
        if (leftData != null) {
            return leftData;
        }
        return process(root.right, root, level + 1, value);
    }

    static class ReturnData {
        int level;
        TreeNode father;

        public ReturnData(int level, TreeNode father) {
            this.level = level;
            this.father = father;
        }
    }
}
