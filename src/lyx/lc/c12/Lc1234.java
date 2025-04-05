package lyx.lc.c12;

import lyx.lc.c0.Lc0076;

/**
 * 1234. 替换子串得到平衡字符串
 *
 * @see Lc0076
 */
public class Lc1234 {
    public int balancedString(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int[] cnt = new int[4];
        for (char c : arr) {
            cnt[index(c)]++;
        }
        int debt = 0;
        for (int i = 0; i < 4; i++) {
            if (cnt[i] > n / 4) {
                cnt[i] = n / 4 - cnt[i];
                debt -= cnt[i];
            } else {
                cnt[i] = 0;
            }
        }
        if (debt == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int l = 0, r = 0; r < n; r++) {
            if (cnt[index(arr[r])]++ < 0) {
                debt--;
            }
            if (debt == 0) {
                while (cnt[index(arr[l])] > 0) {
                    cnt[index(arr[l++])]--;
                }
                ans = Math.min(ans, r - l + 1);
            }
        }
        return ans;
    }

    private int index(char c) {
        if (c == 'Q') return 0;
        if (c == 'W') return 1;
        if (c == 'E') return 2;
        else return 3;
    }
}
