package com.lynx.lc.c1;

import com.lynx.util.BinaryTree.TreeNode;

/**
 * 106.从中序与后序遍历序列构造二叉树
 */
public class Lc0106 {
    private int in;
    private int post;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 中序遍历: [[左], 头, [右]]
        // 后序遍历: [[左], [右], 头]
        in = inorder.length - 1;
        post = postorder.length - 1;
        return buildTree(inorder, postorder, 1L + Integer.MAX_VALUE);
    }

    /**
     * 隐式递归。
     *
     * @param inorder   中序遍历
     * @param postorder 后序遍历
     * @param stop      根节点值，用于分割中序遍历
     * @return 构建后的树。
     */
    private TreeNode buildTree(int[] inorder, int[] postorder, long stop) {
        if (post < 0) {
            // 后序数组遍历完毕
            return null;
        }
        if (inorder[in] == stop) {
            // 当前子树处理完毕
            in--;
            return null;
        }
        int rootValue = postorder[post--];
        TreeNode root = new TreeNode(rootValue);
        // 后序数组逆序访问（根→右→左），因此递归时先构建右子树，再构建左子树
        // 处理右子树时，stop 设为当前根值，中序遇到该值时停止
        root.right = buildTree(inorder, postorder, rootValue);
        // 处理左子树时，沿用之前的 stop，分割左子树范围
        root.left = buildTree(inorder, postorder, stop);
        return root;
    }
}
