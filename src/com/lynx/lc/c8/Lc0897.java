package com.lynx.lc.c8;

import com.lynx.util.TreeNode;

import java.util.Stack;

/**
 * 897.递增顺序搜索数
 */
public class Lc0897 {
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode newRoot = new TreeNode();
        TreeNode temp = newRoot;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            temp.val = cur.val;
            if (cur.right != null) {
                cur = cur.right;
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
            }
            if (!stack.isEmpty()) {
                temp.right = new TreeNode();
                temp = temp.right;
            }
        }
        return newRoot;
    }
}
