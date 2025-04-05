package lyx.lc.c5;

import lyx.util.BinaryTree.TreeNode;

import java.util.*;

/**
 * 501.二叉搜索树中的众数
 */
public class Lc0501 {
    List<Integer> modeList = new ArrayList<>();
    int curValue; // 当前值
    int curCount; // 当前值的节点数量
    int maxCount; // 众数的节点数量

    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] res = new int[modeList.size()];
        for (int i = 0; i < modeList.size(); i++) {
            res[i] = modeList.get(i);
        }
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        // 中序遍历保证有序
        dfs(root.left);
        update(root.val);
        dfs(root.right);
    }

    private void update(int val) {
        if (val == curValue) {
            curCount++;
        } else {
            curValue = val;
            curCount = 1;
        }
        if (curCount == maxCount) {
            modeList.add(curValue);
        }
        if (curCount > maxCount) {
            modeList.clear();
            modeList.add(curValue);
            maxCount = curCount;
        }
    }
}
