package lyx.lc.c30;

/**
 * 3090. 每个字符最多出现两次的最长子字符串
 */
public class Lc3090 {
    public int maximumLengthSubstring(String s) {
        char[] c = s.toCharArray();
        int[] count = new int[26];
        int ans = 0;
        for (int l = 0, r = 0; r < c.length; r++) {
            int x = c[r] - 'a';
            count[x]++;
            while (count[x] > 2) {
                count[c[l++] - 'a']--;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
