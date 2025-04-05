package lyx.lc.c1;

import lyx.util.BinaryTreeWithNext.Node;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 117.填充每个节点的下一个右侧节点指针 II
 */
public class Lc0117 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if (i < size - 1) {
                    cur.next = queue.peek();
                }
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
        return root;
    }
}
