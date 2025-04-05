package lyx.lc.c11;

import lyx.util.BinaryTree.TreeNode;

/**
 * 1123. 最深叶节点的最近公共祖先
 *
 * @date 2024/04/04
 */
public class Lc1123 {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return find(root).node;
    }

    private Info find(TreeNode root) {
        if (root == null) {
            return new Info(0, null);
        }
        Info leftInfo = find(root.left);
        Info rightInfo = find(root.right);
        if (leftInfo.depth > rightInfo.depth) {
            return new Info(leftInfo.depth + 1, leftInfo.node);
        } else if (rightInfo.depth > leftInfo.depth){
            return new Info(rightInfo.depth + 1, rightInfo.node);
        } else {
            return new Info(rightInfo.depth + 1, root);
        }
    }

    private static class Info {
        public int depth;
        public TreeNode node;

        public Info(int depth, TreeNode node) {
            this.depth = depth;
            this.node = node;
        }
    }
}
