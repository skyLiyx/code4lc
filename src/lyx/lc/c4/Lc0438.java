package lyx.lc.c4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 */
public class Lc0438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (p.length() > s.length()) {
            return ans;
        }
        char[] cp = p.toCharArray();
        int[] count1 = new int[26];
        for (char c : cp) {
            count1[c - 'a']++;
        }
        int k = cp.length;
        char[] cs = s.toCharArray();
        int[] count2 = new int[26];
        for (int i = 0; i < k - 1; i++) {
            count2[cs[i] - 'a']++;
        }
        for (int i = k - 1; i < cs.length; i++) {
            count2[cs[i] - 'a']++;
            if (Arrays.equals(count1, count2)) {
                ans.add(i - k + 1);
            }
            count2[cs[i - k + 1] - 'a']--;
        }
        return ans;
    }
}
