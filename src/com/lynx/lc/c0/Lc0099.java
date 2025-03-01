package com.lynx.lc.c0;

import com.lynx.util.BinaryTree.TreeNode;

import java.util.Stack;

/**
 * 99.恢复二叉搜索树
 */
public class Lc0099 {
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        TreeNode prev = null, node1 = null, node2 = null;
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (prev != null && cur.val < prev.val) {
                // 如果当前节点比前一个节点小，说明位置有问题
                if (node1 == null) {
                    // 第一次遇到，那么前一个节点是第一个位置有误的
                    node1 = prev;
                    node2 = cur;
                } else {
                    // 第二次遇到，那么当前节点是第二个位置有误的，
                    // 如果遇不到第二次，说明第一次遇到时两个节点位置就是互相错位的
                    node2 = cur;
                    break;
                }
            }
            prev = cur;
            cur = cur.right;
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
        }
        // 一定不为null
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }
}
