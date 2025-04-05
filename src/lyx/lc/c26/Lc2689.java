package lyx.lc.c26;

/**
 * 2689.从Rope树中提取第K个字符
 */
public class Lc2689 {
    public char getKthCharacter(RopeTreeNode root, int k) {
        if (root.val.length() >= k) {
            return root.val.charAt(k - 1);
        }
        RopeTreeNode left = root.left;
        int leftLen = left == null ? 0 : (left.len == 0 ? left.val.length() : left.len);
        if (leftLen >= k) {
            return getKthCharacter(left, k);
        }
        return getKthCharacter(root.right, k - leftLen);
    }

    public static class RopeTreeNode {
        int len;
        String val;
        RopeTreeNode left;
        RopeTreeNode right;

        public RopeTreeNode() {
        }

        public RopeTreeNode(String val) {
            this.len = 0;
            this.val = val;
        }

        public RopeTreeNode(int len) {
            this.len = len;
            this.val = "";
        }

        public RopeTreeNode(int len, RopeTreeNode left, RopeTreeNode right) {
            this.len = len;
            this.val = "";
            this.left = left;
            this.right = right;
        }
    }
}
