package lyx.lc.c1;

/**
 * 132.分割回文串II
 *
 * @date 2025/03/02
 */
public class Lc0132 {

    int n;
    char[] c;
    int[] ans;

    public int minCut(String s) {
        n = s.length();
        c = s.toCharArray();
        ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            ans[i] = i - 1;
        }
        for (int i = 1; i < n; i++) {
            // 考虑奇数量和偶数量的回文
            helper(i, i);
            helper(i - 1, i);
        }
        return ans[n];
    }

    private void helper(int i, int j) {
        // 中心扩展，扩展后0-j的最小分割次数就是回文串之前的最小分割次数+1(当前回文串)
        while (i >= 0 && j < n && c[i] == c[j]) {
            ans[j + 1] = Math.min(ans[j + 1], ans[i] + 1);
            i--;
            j++;
        }
    }
}
