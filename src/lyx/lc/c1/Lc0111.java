package lyx.lc.c1;

import lyx.util.BinaryTree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 111.二叉树的最小深度
 */
public class Lc0111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            res++;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = deque.pollFirst();
                if (cur.left == null && cur.right == null) {
                    return res;
                }
                if (cur.left != null) {
                    deque.offer(cur.left);
                }
                if (cur.right != null) {
                    deque.offer(cur.right);
                }
            }
        }
        return res;
    }
}
