package lyx.lc.c12;

/**
 * 1208. 尽可能使字符串相等
 */
public class Lc1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        int n = c1.length;
        int ans = 0;
        for (int l = 0, r = 0; r < n; r++) {
            maxCost -= Math.abs(c1[r] - c2[r]);
            while (maxCost < 0) {
                maxCost += Math.abs(c1[l] - c2[l++]);
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
