package lyx.lc.c2;

import lyx.util.BinaryTree.TreeNode;

import java.util.Stack;

/**
 * 230. 二叉搜索树中第 K 小的元素
 */
public class Lc0230 {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode cur = stack.pop();
                if (--k == 0) {
                    return cur.val;
                }
                root = cur.right;
            }
        }
        return -1;
    }
}
