package lyx.lc.c1;

import lyx.util.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 107.二叉树的层序遍历 II
 */
public class Lc0107 {
     public List<List<Integer>> levelOrderBottom(TreeNode root) {
         List<List<Integer>> res = new LinkedList<>();
         if (root == null) {
             return res;
         }
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
             res.add(0, list);
         }
         return res;
     }
}
