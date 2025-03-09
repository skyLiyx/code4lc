package com.lynx.lc.c3;

import com.lynx.util.BinaryTree.TreeNode;

/**
 * 337.打家劫舍 III
 */
public class Lc0337 {

    private static int yes;
    private static int no;

    public int rob(TreeNode root) {
        f(root);
        return Math.max(yes, no);
    }

    private void f(TreeNode root) {
        if (root == null) {
            yes = 0;
            no = 0;
        } else {
            int y = root.val;
            int n = 0;
            f(root.left);
            y += no;
            n += Math.max(yes, no);
            f(root.right);
            y += no;
            n += Math.max(yes, no);
            yes = y;
            no = n;
        }
    }
}
