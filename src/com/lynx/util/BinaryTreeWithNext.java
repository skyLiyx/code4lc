package com.lynx.util;

/**
 * 特殊的二叉树节点，针对题目116和117。
 *
 * @see com.lynx.lc.c1.Lc0116
 * @see com.lynx.lc.c1.Lc0117
 */
public class BinaryTreeWithNext {

    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }

        // for debug
        public static Node build(String[] vals) {
            return build(vals, 0);
        }

        private static Node build(String[] vals, int i) {
            if (i >= vals.length || vals[i].equals("null")) {
                return null;
            }
            return new Node(
                    Integer.parseInt(vals[i]),
                    build(vals, i * 2 + 1),
                    build(vals, i * 2 + 2),
                    null
            );
        }

        // for debug
        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
}
