package com.lynx.lc.c1;

import com.lynx.util.BinaryTree.TreeNode;

import java.util.*;

/**
 * 103.二叉树的锯齿形层序遍历
 */
public class Lc0103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // 维护一个双向队列，通过操作队列两边实现同时入队列和出队列
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        // 当前顺序
        boolean reverse = false;
        while (!deque.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            TreeNode cur;
            if (reverse) {
                // 偶数层从最左边开始出队列，出队顺序：右 -> 左
                cur = deque.pollFirst();
                list.add(cur.val);
                // 不影响左边出队，子节点用addLast入队到右边
                // addLast先入的靠前，所以先入右子节点，后入左子节点
                if (cur.right != null) {
                    deque.addLast(cur.right);
                }
                if (cur.left != null) {
                    deque.addLast(cur.left);
                }
            } else {
                // 奇数层从最右边开始出队列，出队顺序：左 -> 右
                cur = deque.pollLast();
                list.add(cur.val);
                // 不影响右边出队，子节点用addFirst入队到左边
                // addFirst先入的靠后，所以先入左子节点，后入右子节点
                if (cur.left != null) {
                    deque.addFirst(cur.left);
                }
                if (cur.right != null) {
                    deque.addFirst(cur.right);
                }
            }
            res.add(list);
            // 当前层遍历完，调整顺序
            reverse = !reverse;
        }
        return res;
    }
}
