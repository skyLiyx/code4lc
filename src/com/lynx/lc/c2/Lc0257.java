package com.lynx.lc.c2;

import com.lynx.util.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 257.二叉树的所有路径
 */
public class Lc0257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        backtrace(res, root, new ArrayList<>());
        return res;
    }

    private void backtrace(List<String> res, TreeNode root, List<String> path) {
        if (root == null) {
            return;
        }
        path.add(String.valueOf(root.val));
        if (root.left == null && root.right == null) {
            res.add(String.join("->", path));
            path.remove(path.size() - 1);
            return;
        }
        backtrace(res, root.left, path);
        backtrace(res, root.right, path);
        path.remove(path.size() - 1);
    }
}
