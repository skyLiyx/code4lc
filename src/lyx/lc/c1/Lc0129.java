package lyx.lc.c1;

import lyx.util.BinaryTree.TreeNode;

/**
 * 129. 求根节点到叶节点数字之和
 */
public class Lc0129 {
    private static int ans;

    public int sumNumbers(TreeNode root) {
        ans = 0;
        f(root, 0);
        return ans;
    }

    private void f(TreeNode root, int num) {
        num = num * 10 + root.val;
        if (root.left == null && root.right == null) {
            ans += num;
            return;
        }
        if (root.left != null) {
            f(root.left, num);
        }
        if (root.right != null) {
            f(root.right, num);
        }
    }
}
