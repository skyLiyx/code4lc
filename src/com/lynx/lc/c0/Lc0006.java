package com.lynx.lc.c0;

/**
 * 6. Z 字形变换
 */
public class Lc0006 {
    public String convert(String s, int numRows) {
        int n = s.length();
        if (n == 1 || numRows == 1 || n < numRows) {
            return s;
        }
        char[] arr = s.toCharArray();
        int batch = 2 * numRows - 2;
        StringBuilder sb = new StringBuilder();
        // 最上层
        for (int i = 0; i < n; i += batch) {
            sb.append(arr[i]);
        }
        // 中间层
        for (int row = 1; row < numRows - 1; row++) {
            for (int i = row, j = batch - row; i < n; i += batch, j += batch) {
                sb.append(arr[i]);
                if (j < n) {
                    sb.append(arr[j]);
                }
            }
        }
        // 最下层
        for (int i = numRows - 1; i < n; i += batch) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
