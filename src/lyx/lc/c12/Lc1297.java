package lyx.lc.c12;

import java.util.HashMap;
import java.util.Map;

/**
 * 1297. 子串的最大出现次数
 */
public class Lc1297 {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        // 更大的子串也包含更小的，所以只需要按小串统计
        char[] arr = s.toCharArray();
        int ans = 0;
        int[] count = new int[26];
        int type = 0;
        for (int i = 0; i < minSize - 1; i++) {
            if (count[arr[i] - 'a']++ == 0) {
                type++;
            }
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = minSize - 1; i < arr.length; i++) {
            if (count[arr[i] - 'a']++ == 0) {
                type++;
            }
            if (type <= maxLetters) {
                String sub = new String(arr, i - minSize + 1, minSize);
                int cnt = map.getOrDefault(sub, 0) + 1;
                map.put(sub, cnt);
                ans = Math.max(ans, cnt);
            }
            if (--count[arr[i - minSize + 1] - 'a'] == 0) {
                type--;
            }
        }
        return ans;
    }
}
