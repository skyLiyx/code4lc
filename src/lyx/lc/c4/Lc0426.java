package lyx.lc.c4;

import java.util.ArrayList;
import java.util.List;

/**
 * 426. 将二叉搜索树转化为排序的双向链表
 */
public class Lc0426 {
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        List<Node> list = new ArrayList<>();
        collect(list, root);
        for (int i = 1; i < list.size(); i++) {
            Node prev = list.get(i - 1);
            Node curr = list.get(i);
            prev.right = curr;
            curr.left = prev;
        }
        list.get(0).left = list.get(list.size() - 1);
        list.get(list.size() - 1).right = list.get(0);
        return list.get(0);
    }

    public void collect(List<Node> list, Node root) {
        if (root == null) {
            return;
        }
        collect(list, root.left);
        list.add(root);
        collect(list, root.right);
    }

    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
