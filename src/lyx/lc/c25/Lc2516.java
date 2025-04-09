package lyx.lc.c25;

/**
 * 2516. 每种字符至少取 K 个
 */
public class Lc2516 {
    public int takeCharacters(String s, int k) {
        char[] c = s.toCharArray();
        int n = c.length;
        if (n < 3 * k) {
            return -1;
        }
        int[] count = new int[3];
        for (char ch : c) {
            ++count[ch - 'a'];
        }
        if (count[0] < k || count[1] < k || count[2] < k) {
            return -1;
        }
        int ans = 0;
        for (int l = 0, r = 0; r < n; r++) {
            count[c[r] - 'a']--;
            while (count[c[r] - 'a'] < k) {
                count[c[l++] - 'a']++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return n - ans;
    }
}
