package lyx.lc.c13;

import java.util.Arrays;

/**
 * 1397. 找到所有好字符串
 *
 * @apiNote 数位DP
 */
public class Lc1397 {
    private static final long MOD = (long)1e9 + 7;

    public int findGoodStrings(int n, String s1, String s2, String evil) {
        int[][] dp = new int[n][evil.length()];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int[] next = getNextArray(evil);
        return f(s1.toCharArray(), s2.toCharArray(), evil.toCharArray(), next, 0, 0, true, true, dp);
    }

    public int[] getNextArray(String evil) {
        char[] arr = evil.toCharArray();
        int[] next = new int[arr.length];
        for(int j = 0, i = 1; i < arr.length; i++) {
            while(j > 0 && evil.charAt(i) != evil.charAt(j)) {
                j = next[j - 1];
            }
            if(evil.charAt(i) == evil.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    /**
     * @param s1          字典序下限
     * @param s2          字典序上限
     * @param evil        不能包含的子串
     * @param next        KMP辅助数组
     * @param index       当前索引
     * @param evilLen     当前索引前面已占用的长度
     * @param isLowLimit  当前索引是否存在下限
     * @param isHighLimit 当前索引是否存在上限
     * @param dp          缓存
     */
    public int f(char[] s1, char[] s2, char[] evil, int[] next, int index, int evilLen, boolean isLowLimit, boolean isHighLimit, int[][] dp) {
        if (evilLen == evil.length) {
            return 0;
        }
        if (index == s1.length) {
            return 1;
        }
        if (!isLowLimit && !isHighLimit && dp[index][evilLen] != -1) {
            return dp[index][evilLen];
        }
        long ans = 0;
        char low = isLowLimit ? s1[index] : 'a';
        char high = isHighLimit ? s2[index] : 'z';
        for (char j = low; j <= high; j++) {
            int l = evilLen;
            while (l > 0 && j != evil[l]) {
                l = next[l - 1];
            }
            if (l == 0 && j != evil[l]) {
                l = -1;
            }
            ans = (ans + f(s1, s2, evil, next, index + 1, l + 1, isLowLimit && j == low, isHighLimit && j == high, dp)) % MOD;
        }
        if (!isLowLimit && !isHighLimit) {
            dp[index][evilLen] = (int)ans;
        }
        return (int)ans;
    }
}
