package lyx.lc.c6;

import lyx.util.BinaryTree.TreeNode;

import java.util.*;

/**
 * 653.两数之和IV - 输入二叉搜索树
 */
public class Lc0653 {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return findTarget(set, root, k);
    }

    private boolean findTarget(Set<Integer> set, TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (findTarget(set, root.left, k)) {
            return true;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return findTarget(set, root.right, k);
    }
}
