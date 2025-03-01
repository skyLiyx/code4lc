package com.lynx.lc.c0;

/**
 * 96.不同的二叉搜索树
 */
public class Lc0096 {
    public int numTrees(int n) {
        // dp[n]表示n个节点可以组成的搜索二叉树的数量
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) { // i-节点数量
            for (int j = 1; j <= i; j++) { //j-头节点
                int left = dp[j - 1];
                int right = dp[i - j];
                dp[i] += left * right;
            }
        }
        return dp[n];
    }
}
