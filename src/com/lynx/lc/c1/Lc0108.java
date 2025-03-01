package com.lynx.lc.c1;

import com.lynx.util.BinaryTree.TreeNode;

/**
 * 108.将有序数组转换为二叉搜索树
 */
public class Lc0108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return generate(nums, 0, nums.length - 1);
    }

    private TreeNode generate(int[] nums, int begin, int end) {
        if (begin > end) {
            return null;
        }
        int mid = begin + ((end - begin) >> 1);
        return new TreeNode(
                nums[mid],
                generate(nums, begin, mid - 1),
                generate(nums, mid + 1, end)
        );
    }
}
