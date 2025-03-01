package com.lynx.lc.c0;

import com.lynx.util.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 95.不同的二叉搜索树 II
 */
public class Lc0095 {
    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }

    private List<TreeNode> generate(int begin, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (begin > end) {
            list.add(null);
            return list;
        }
        for (int i = begin; i <= end; i++) {
            List<TreeNode> left = generate(begin, i - 1);
            List<TreeNode> right = generate(i + 1, end);
            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    list.add(new TreeNode(i, leftNode, rightNode));
                }
            }
        }
        return list;
    }
}
