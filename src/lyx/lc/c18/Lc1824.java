package lyx.lc.c18;

import java.util.*;

/**
 * 1824. 最少侧跳次数
 */
public class Lc1824 {

    /* ************************************ 动态规划 ************************************** */
    private static final int[] help1 = {0,1,2,3,1,2};

    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        int[] ans = new int[4];
        int[] tmp = new int[4];
        for (int index = n - 2; index >= 0; index--) {
            for (int no = 1; no < 4; no++) {
                if (obstacles[index + 1] != no) {
                    continue;
                } else if (obstacles[index] == 0) {
                    tmp[no] = Math.min(ans[help1[no + 1]], ans[help1[no + 2]]) + 1;
                } else if (obstacles[index] == help1[no + 1]) {
                    tmp[no] = ans[help1[no + 2]] + 1;
                } else {
                    tmp[no] = ans[help1[no + 1]] + 1;
                }
                System.arraycopy(tmp, 1, ans, 1, 3);
            }
        }
        return ans[2];
    }

    public int minSideJumps1(int[] obstacles) {
        int[][] dp = new int[obstacles.length][4];
        for (int i = 0; i < obstacles.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        // 从开头的中间跑道2开始
        return f(obstacles, 0, 2, dp);
    }

    /**
     * 暴力递归.
     */
    private int f(int[] obstacles, int index, int no, int[][] dp) {
        if (index == obstacles.length - 1) {
            return 0;
        }
        if (dp[index][no] != -1) {
            return dp[index][no];
        }
        // 不需要跳(贪心，能不跳就不跳)
        if (obstacles[index + 1] != no) {
            dp[index][no] = f(obstacles, index + 1, no, dp);
            return dp[index][no];
        }
        // 需要跳
        // 1.另外两个都能跳，选最小的跳
        // 2.只能跳一个，没得选，直接跳
        int ans;
        if (obstacles[index] == 0) {
            ans = Math.min(f(obstacles, index + 1, help1[no + 1], dp), f(obstacles, index + 1, help1[no + 2], dp));
        } else if (obstacles[index] == help1[no + 1]) {
            ans = f(obstacles, index + 1, help1[no + 2], dp);
        } else {
            ans = f(obstacles, index + 1, help1[no + 1], dp);
        }
        dp[index][no] = ans + 1; // 跳了就+1
        return dp[index][no];
    }
    /* ************************************ 动态规划 ************************************** */

    /* ************************************ 01BFS ************************************** */
    private static final int[] help2 = {0,1,2,0,1};

    public int minSideJumps3(int[] obstacles) {
        int n = obstacles.length;
        int[][] distance = new int[3][n];
        for (int i = 0; i < 3; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        distance[1][0] = 0;
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addLast(new int[]{1, 0});
        while (!deque.isEmpty()) {
            int[] cur = deque.pollFirst();
            int row = cur[0];
            int col = cur[1];
            int d = distance[row][col];
            if (col == n - 1) {
                return d;
            }
            if (obstacles[col + 1] != row + 1 && d < distance[row][col + 1]) {
                // 存在边权为0
                distance[row][col + 1] = d;
                deque.addFirst(new int[]{row, col + 1});
            }
            for (int i = 1; i <= 2; i++) {
                // 上下边权为1且能走
                if (obstacles[col] != help2[row + i] + 1 && d + 1 < distance[help2[row + i]][col]) {
                    distance[help2[row + i]][col] = d + 1;
                    deque.addLast(new int[]{help2[row + i], col});
                }
            }
        }
        return -1;
    }
    /* ************************************ 01BFS ************************************** */
}