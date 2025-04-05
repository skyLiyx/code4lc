package lyx.lc.c17;

/**
 * 1706.球会落在何处
 *
 * @date 2025/02/15
 */
public class Lc1706 {
    public int[] findBall(int[][] grid) {
        int n = grid[0].length;
        if (n == 1) {
            return new int[]{-1};
        }
        // 初始化所有球的位置
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = i;
            // 一层一层的计算每个球的位置
            for (int[] row : grid) {
                res[i] = findBall(row, res[i]);
            }
        }
        return res;
    }

    private int findBall(int[] row, int pre) {
        if (pre == -1) {
            return -1;
        }
        int n = row.length;
        if (pre == 0) {
            // 当前球在最左边，只能向右落下
            if (row[0] == 1 && row[1] == 1) {
                return 1;
            }
        } else if (pre == n - 1) {
            // 当前球在最右边，只能向左落下
            if (row[n - 1] == -1 && row[n - 2] == -1) {
                return n - 2;
            }
        } else {
            // 当前球在中间，可以向两边落下
            if (row[pre] == 1 && row[pre + 1] == 1) {
                return pre + 1;
            }
            if (row[pre] == -1 && row[pre - 1] == -1) {
                return pre - 1;
            }
        }
        return -1;
    }
}
