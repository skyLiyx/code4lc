package com.lynx.lc.c14;

import com.lynx.util.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1469.寻找所有的独生节点
 */
public class Lc1469 {
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, false, res);
        return res;
    }

    private void dfs(TreeNode root, boolean lonely, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (lonely) {
            res.add(root.val);
        }
        dfs(root.left, root.right == null, res);
        dfs(root.right, root.left == null, res);
    }
}
