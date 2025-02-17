package com.lynx.lc.c1;

import com.lynx.util.TreeNode;

import java.util.*;

/**
 * 102.二叉树的层序遍历
 */
public class Lc0102 {
     public List<List<Integer>> levelOrder(TreeNode root) {
         List<List<Integer>> res = new ArrayList<>();
         if (root == null) {
             return res;
         }
         // 利用双向队列，先进先出
         // 先放入根节点，取出一个节点时，将其左右子节点加入队列尾部
         Queue<TreeNode> queue = new LinkedList<>();
         queue.offer(root);
         while (!queue.isEmpty()) {
             int n = queue.size();
             List<Integer> list = new ArrayList<>();
             for (int i = 0; i < n; i++) {
                 TreeNode cur = queue.poll();
                 list.add(cur.val);
                 if (cur.left != null) {
                     queue.offer(cur.left);
                 }
                 if (cur.right != null) {
                     queue.offer(cur.right);
                 }
             }
             res.add(list);
         }
         return res;
     }
}
