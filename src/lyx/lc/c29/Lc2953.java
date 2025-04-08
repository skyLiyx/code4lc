package lyx.lc.c29;

import java.util.Arrays;

/**
 * 2953. 统计完全子字符串
 */
public class Lc2953 {
    public int countCompleteSubstrings(String word, int k) {
        char[] s = word.toCharArray();
        int n = s.length;
        if (n < k) {
            return 0;
        }
        int ans = 0;
        // 分组，每一组中都满足相邻字符的差不超过2
        for (int l = 0, r = 0; r < n; ) {
            while (r + 1 < n && Math.abs(s[r + 1] - s[r]) <= 2) {
                r++;
            }
            ans += f(word.substring(l, r + 1), k);
            l = r + 1;
            r = l;
        }
        return ans;
    }

    // 获取子串中每个字符都恰好出现 k 次的子串个数
    private int f(String str, int k) {
        char[] s = str.toCharArray();
        int[] count = new int[26];
        int ans = 0;
        // 枚举出现的字符数量
        for (int m = 1; m <= 26 && m * k <= s.length; m++) {
            int len = m * k; // 窗口大小
            for (int i = 0; i < len - 1; i++) {
                count[s[i] - 'a']++;
            }
            for (int i = len - 1; i < s.length; i++) {
                count[s[i] - 'a']++;
                boolean isOk = true;
                for (int j = 0; j < 26; j++) {
                    if (count[j] > 0 && count[j] != k) {
                        isOk = false;
                        break;
                    }
                }
                if (isOk) {
                    ans++;
                }
                count[s[i - len + 1] - 'a']--;
            }
            Arrays.fill(count, 0);
        }
        return ans;
    }
}
