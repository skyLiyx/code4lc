package lyx.lc.c10;

import lyx.util.BinaryTree.TreeNode;

/**
 * 1022.从根到叶的二进制数之和
 */
public class Lc1022 {

    private static int sum = 0;

    public int sumRootToLeaf(TreeNode root) {
        sum = 0;
        backtrace(root, new StringBuilder());
        return sum;
    }

    private void backtrace(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val);
        System.out.println(sb);
        if (root.left == null && root.right == null) {
            sum += Integer.valueOf(sb.toString(), 2);
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        backtrace(root.left, sb);
        backtrace(root.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}
