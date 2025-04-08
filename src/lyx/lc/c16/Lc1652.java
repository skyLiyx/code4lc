package lyx.lc.c16;

import java.util.Arrays;

/**
 * 1652. 拆炸弹
 */
public class Lc1652 {
    public int[] decrypt(int[] code, int k) {
        if (k == 0) {
            Arrays.fill(code, 0);
            return code;
        }
        int n = code.length;
        int[] ans = new int[n];
        int w = Math.abs(k);
        int sum = 0;
        for (int i = 0; i < w - 1; i++) {
            if (k > 0) {
                sum += code[i + 1];
            } else {
                sum += code[n - w + i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (k > 0) {
                sum += code[(i + w) % n];
                ans[i] = sum;
                sum -= code[(i + 1) % n];
            } else {
                sum += code[(n - 1 + i) % n];
                ans[i] = sum;
                sum -= code[(n - w + i) % n];
            }
        }
        return ans;
    }
}
