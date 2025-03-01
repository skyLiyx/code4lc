package com.lynx.lc.c8;

import com.lynx.util.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 872.叶子相似的树
 */
public class Lc0872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return Objects.equals(getLeafNodeValues(root1), getLeafNodeValues(root2));
    }

    private List<Integer> getLeafNodeValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        getLeafNodeValues(root, list);
        return list;
    }

    private void getLeafNodeValues(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(root.val);
        } else {
            getLeafNodeValues(root.left, list);
            getLeafNodeValues(root.right, list);
        }
    }
}
