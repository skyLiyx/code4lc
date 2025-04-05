package lyx.lc.c4;

import java.util.Arrays;

/**
 * 465. 最优账单平衡
 */
public class Lc0465 {
    public int minTransfers(int[][] transactions) {
        // 预处理数组，消除收支平衡的人
        int[] help = new int[12];
        for (int[] transaction : transactions) {
            int from = transaction[0];
            int to = transaction[1];
            int amount = transaction[2];
            help[from] -= amount;
            help[to] += amount;
        }
        // 人数
        int n = 0;
        for (int i = 0; i < help.length; i++) {
            if (help[i] != 0) {
                n++;
            }
        }
        int[] trans = new int[n];
        int index = 0;
        for (int i = 0; i < help.length; i++) {
            if (help[i] != 0) {
                trans[index++] = help[i];
            }
        }
        int[] dp = new int[1 << 12];
        Arrays.fill(dp, -1);
        // 经过处理之后的数组，要找尽可能多的和为0的子集
        // 这样每个子集内部消化债务，交易数就越小
        return n - f(trans, (1 << n) - 1, 0, n, dp);
    }

    private int f(int[] trans, int set, int sum, int n, int[] dp) {
        if (dp[set] != -1) {
            return dp[set];
        }
        int ans = 0;
        if ((set & (set - 1)) != 0) { // 剩余集合中不止一个元素
            if (sum == 0) {
                // 尝试开始一个新子集
                for (int i = 0; i < n; i++) {
                    if ((set & (1 << i)) != 0) {
                        // 找到任何一个元素，去除，然后再剩下的集合中尝试
                        ans = f(trans, set ^ (1 << i), sum - trans[i], n, dp) + 1;
                        break;
                    }
                }
            } else {
                // 当前子集没凑够累加和为0
                for (int i = 0; i < n; i++) {
                    if ((set & (1 << i)) != 0) {
                        // 用当前元素尝试去凑子集
                        ans = Math.max(ans, f(trans, set ^ (1 << i), sum - trans[i], n, dp));
                    }
                }
            }
        }
        dp[set] = ans;
        return dp[set];
    }
}
