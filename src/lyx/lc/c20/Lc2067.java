package lyx.lc.c20;

/**
 * 2067. 等计数子串的数量
 */
public class Lc2067 {
    public int equalCountSubstrings(String s, int count) {
        char[] c = s.toCharArray();
        int n = c.length;
        int ans = 0;
        for (int m = 1; m <= 26 && count * m <= n; m++) {
            int k = count * m;
            int[] cnt = new int[26];
            for (int i = 0; i < k - 1; i++) {
                cnt[c[i] - 'a']++;
            }
            for (int i = k - 1; i < n; i++) {
                cnt[c[i] - 'a']++;
                boolean isOk = true;
                for (int j = 0; j < 26; j++) {
                    if (cnt[j] > 0 && cnt[j] != count) {
                        isOk = false;
                        break;
                    }
                }
                if (isOk) {
                    ans++;
                }
                cnt[c[i - k + 1] - 'a']--;
            }
        }
        return ans;
    }
}
