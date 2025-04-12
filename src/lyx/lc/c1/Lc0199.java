package lyx.lc.c1;

import lyx.util.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 199. 二叉树的右视图
 */
public class Lc0199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[100];
        f(root, ans, visited, 0);
        return ans;
    }

    private void f(TreeNode root, List<Integer> ans, boolean[] visited, int level) {
        if (root == null) {
            return;
        }
        if (!visited[level]) {
            ans.add(root.val);
            visited[level] = true;
        }
        f(root.right, ans, visited, level + 1);
        f(root.left, ans, visited, level + 1);
    }
}
