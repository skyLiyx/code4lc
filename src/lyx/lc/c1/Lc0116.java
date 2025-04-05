package lyx.lc.c1;

import lyx.util.BinaryTreeWithNext.Node;

/**
 * 116.填充每个节点的下一个右侧节点指针
 */
public class Lc0116 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        connect(root.left, root.right);
        return root;
    }

    private void connect(Node left, Node right) {
        if (left == null || right == null) {
            return;
        }
        connect(left.left, left.right);
        connect(right.left, right.right);
        while (left != null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }
    }
}
