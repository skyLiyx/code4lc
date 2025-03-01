package com.lynx.lc.c0;

import com.lynx.util.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94.二叉树的中序遍历
 */
public class Lc0094 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        // 将所有左边界压入栈，每弹出一个节点，再次压入该节点右子节点的左边界
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode cur = stack.pop();
                res.add(cur.val);
                root = cur.right;
            }
        }
        return res;
    }
}
