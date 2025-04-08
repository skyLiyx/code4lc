package lyx.lc.c14;

import java.util.Arrays;
import java.util.List;

/**
 * 1456. 定长子串中元音的最大数目
 *
 * @apiNote 滑动窗口
 */
public class Lc1456 {
    private static final List<Character> VOWELS = Arrays.asList(
            'a', 'e', 'i', 'o', 'u'
    );

    public int maxVowels(String s, int k) {
        char[] arr = s.toCharArray();
        int ans = 0;
        for (int i = 0, count = 0; i < arr.length; i++) {
            // 1.进入窗口
            if (VOWELS.contains(arr[i])) {
                count++;
            }
            if (i < k - 1) {
                continue;
            }
            // 2.更新答案
            ans = Math.max(ans, count);
            if (ans == k) {
                return k;
            }
            // 3.离开窗口
            char out = arr[i - k + 1];
            if (VOWELS.contains(out)) {
                count--;
            }
        }
        return ans;
    }
}
