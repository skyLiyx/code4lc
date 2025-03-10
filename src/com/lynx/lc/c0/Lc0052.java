package com.lynx.lc.c0;

/**
 * 52.N皇后 II
 */
public class Lc0052 {
    public int totalNQueens(int n) {
        return totalNQueens0((1 << n) - 1, 0, 0, 0);
    }

    private int totalNQueens0(int limit, int col, int left, int right) {
        if (col == limit) {
            return 1;
        }
        // 当前的限制：列限制 + 两个对角线限制
        int ban = col | left | right;
        // 当前能放的位置
        int candidate = limit & (~ban);
        // 放置位置
        int place = 0;
        int ans = 0;
        while (candidate != 0) {
            place = candidate & (-candidate); // 提取最右侧的1
            candidate ^= place; // 然后抹掉这一位的1
            ans += totalNQueens0(limit, col | place, (left | place) >> 1, (right | place) << 1);
        }
        return ans;
    }
}
