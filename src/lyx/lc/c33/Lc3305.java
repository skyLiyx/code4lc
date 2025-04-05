package lyx.lc.c33;

import java.util.Arrays;

/**
 * 3305.元音辅音字符串计数 I
 *
 * @date 2025/03/12
 */
public class Lc3305 {
    private int n;

    private final int[] cnt = new int[26];

    private final int[] idx = new int[] {
            0, 'e' - 'a', 'i' - 'a', 'o' - 'a', 'u' - 'a'
    };

    public int countOfSubstrings(String word, int k) {
        n = word.length();
        // 恰好包含k个 = 至少包含k个 - 至少包含k+1个
        return count(word, k) - count(word, k + 1);
    }

    private int count(String word, int k) {
        Arrays.fill(cnt, 0);
        int ans = 0;
        for (int l = 0, r = 0; r < word.length(); r++) {
            char c = word.charAt(r);
            cnt[c - 'a']++;
            while (check(l, r, k)) {
                // 如果当前满足条件，那么从l开始到r，以及到r后续的所有子串都满足
                ans += n - r;
                // 右移l，同时减去对应字符的数量，后续由于l不同所以不会重复计数
                cnt[word.charAt(l) - 'a']--;
                l++;
            }
        }
        return ans;
    }

    private boolean check(int l, int r, int k) {
        int len = r - l + 1;
        if (len < 5 + k) {
            return false;
        }
        // 依次检查5个元音字母数量，并减去长度，减完后检查辅音长度
        for (int i : idx) {
            if (cnt[i] == 0) {
                return false;
            }
            len -= cnt[i];
        }
        return len >= k;
    }
}
