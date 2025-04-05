package lyx.lc.c1;

import lyx.util.BinaryTree.TreeNode;

/**
 * 105.从前序与中序遍历序列构造二叉树
 */
public class Lc0105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 前序遍历：[头, [左], [右]]
        // 中序遍历：[[左], 头, [右]]
        // return buildTree_v1(preorder, 0, inorder, 0, inorder.length);
        return buildTree_v2(preorder, inorder, 1L + Integer.MAX_VALUE);
    }

    /**
     * 常规递归方法。
     * @param preorder 当前树的前序遍历
     * @param lp       当前子树在前序遍历中的起点
     * @param inorder  当前树的中序遍历
     * @param li       当前子树在中序遍历中的起点
     * @param ri       当前子树在中序遍历中的终点
     * @return 构建后的节点
     */
    private TreeNode buildTree_v1(int[] preorder, int lp, int[] inorder, int li, int ri) {
        int rootValue = preorder[lp]; // 前序遍历的第一个就是头节点
        TreeNode root = new TreeNode(rootValue);
        // 在中序遍历中找到头节点的位置
        int i = 0;
        while (i + li < ri && inorder[i + li] != rootValue) {
            i++;
        }
        // 找到中序遍历中的头节点位置后，该位置左边就是左子树的中序遍历，右边就是右子树的中序遍历
        // 同样前序遍历中的头节点之后相同长度的范围就是左子树的前序遍历，剩余就是右子树的前序遍历
        if (i != 0) {
            root.left = buildTree_v1(preorder, lp + 1, inorder, li, li + i);
        }
        if (i + li != ri - 1) {
            root.right = buildTree_v1(preorder, lp + 1 + i, inorder, li + i + 1, ri);
        }
        return root;
    }

    private int pre = 0;
    private int in = 0;

    /**
     * 隐式递归。
     *
     * @param preorder 前序遍历
     * @param inorder  中序遍历
     * @param stop     当前根节点值，用于分割中序遍历
     * @return 构建后的节点
     */
    private TreeNode buildTree_v2(int[] preorder, int[] inorder, long stop) {
        if (pre == preorder.length) {
            // 前序遍历完成
            return null;
        }
        if (inorder[in] == stop) {
            // 遇到根节点，当前子树处理完毕
            in++;
            return null;
        }
        int rootValue = preorder[pre++];
        TreeNode root = new TreeNode(rootValue);
        root.left = buildTree_v2(preorder, inorder, rootValue);
        root.right = buildTree_v2(preorder, inorder, stop);
        return root;
    }
}
