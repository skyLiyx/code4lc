package lyx.lc.c9;

import lyx.util.BinaryTree.TreeNode;

/**
 * 968. 监控二叉树
 */
public class Lc0968 {
    private static int ans;

    public int minCameraCover(TreeNode root) {
        ans = 0;
        int status = f(root);
        return status == 0 ? ans + 1 : ans;
    }

    /**
     * 定义节点状态值：
     * 0: 无摄像头，且未被监控
     * 1: 无摄像头，但被监控
     * 2: 有摄像头
     */
    private int f(TreeNode root) {
        if (root == null) {
            return 1;
        }
        int leftStatus = f(root.left);
        int rightStatus = f(root.right);
        if (leftStatus == 0 || rightStatus == 0) {
            // 只要有一个子节点没被监控，当前必须要摄像头
            ans++;
            return 2;
        }
        if (leftStatus == 1 && rightStatus == 1) {
            // 两个子节点都不能给当前节点提供监控
            return 0;
        }
        return 1;
    }
}
