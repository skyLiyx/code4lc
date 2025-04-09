package lyx.lc.c27;

/**
 * 2730. 找到最长的半重复子字符串
 */
public class Lc2730 {
    public int longestSemiRepetitiveSubstring(String s) {
        char[] c = s.toCharArray();
        int ans = 1;
        int repeat = -1;
        for (int l = 0, r = 1; r < c.length; r++) {
            if (c[r] == c[r - 1]) {
                if (repeat != -1) {
                    l = repeat;
                }
                repeat = r;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
