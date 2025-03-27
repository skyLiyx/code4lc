package com.lynx.util;

public class BinaryTree {
    /**
     * 二叉树节点。
     */
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        // for debug
        public static TreeNode build(String[] vals) {
            return build(vals, 0);
        }

        private static TreeNode build(String[] vals, int i) {
            if (i >= vals.length || vals[i].equals("null")) {
                return null;
            }
            return new TreeNode(
                    Integer.parseInt(vals[i]),
                    build(vals, i * 2 + 1),
                    build(vals, i * 2 + 2)
                    );
        }
    }
}
