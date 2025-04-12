package lyx.lc.c1;

import lyx.util.BinaryTree.TreeNode;

/**
 * 114.二叉树展开为链表
 */
public class Lc0114 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode l = root.left;
        TreeNode r = root.right;
        if (l != null) {
            // 当前节点左孩子不为空，将其放到右孩子
            root.right = l;
            // 然后把原本的右孩子放到左孩子最右节点的右边
            while (l.right != null) {
                l = l.right;
            }
            l.right = r;
            root.left = null;
        }
        flatten(root.right);
    }
}
