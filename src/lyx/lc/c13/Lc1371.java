package lyx.lc.c13;

import java.util.Arrays;

/**
 * 1371. 每个元音包含偶数次的最长子字符串
 */
public class Lc1371 {
    public int findTheLongestSubstring(String s) {
        int ans = 0;
        int[] map = new int[32];
        Arrays.fill(map, -2);
        map[0] = -1;
        // mask表示各元音出现次数的情况
        // 比如01010表示u、o、i、e、a分别出现偶、奇、偶、奇、偶次
        for (int i = 0, mask = 0, b; i < s.length(); i++) {
            b = get(s.charAt(i));
            if (b != -1) {
                // 遇到了元音字母
                mask ^= 1 << b;
            }
            if (map[mask] != -2) {
                ans = Math.max(ans, i - map[mask]);
            } else {
                map[mask] = i;
            }
        }
        return ans;
    }

    private int get(char c) {
        switch (c) {
            case 'a': return 0;
            case 'e': return 1;
            case 'i': return 2;
            case 'o': return 3;
            case 'u': return 4;
            default: return -1;
        }
    }
}
