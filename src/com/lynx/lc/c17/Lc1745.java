package com.lynx.lc.c17;

/**
 * 1745.分割回文串 IV
 *
 * @date 2025/03/04
 */
public class Lc1745 {
    public boolean checkPartitioning(String s) {
        if (s == null || s.length() < 3) {
            return false;
        }
        // 使用manacher算法预处理得出每个位置的回文直径
        int[] d = manacher(s);
        // 刚好分割3个回文串，那么预处理后保证找两个端点，
        // 保证两点之间和两边的三块区域都是回文直径覆盖范围
        for (int i = 2; i <= d.length - 5; i += 2) {
            // i 左边的终点（不包含）
            for (int j = i + 2; j <= d.length - 3; j += 2) {
                // j 右边的起点（包含）
                if (check(d, 0, i) && check(d, i, j) && check(d, j, d.length - 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check(int[] d, int l, int r) {
        return d[l + ((r - l) >> 1)] >= ((r - l) >> 1);
    }

    private int[] manacher(String s) {
        StringBuilder sb = new StringBuilder("#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i)).append("#");
        }
        char[] arr = sb.toString().toCharArray();
        int[] d = new int[arr.length];
        int C = -1;
        int R = -1;
        for (int i = 0; i < arr.length; i++) {
            if (i < R) {
                d[i] = Math.min(d[C * 2 - i], R - i);
            }
            while (i + (d[i] + 1) < arr.length && i - (d[i] + 1) >= 0 && arr[i + (d[i] + 1)] == arr[i - (d[i] + 1)]) {
                d[i]++;
            }
            if (i + d[i] > R) {
                R = i + d[i];
                C = i;
            }
        }
        return d;
    }
}
