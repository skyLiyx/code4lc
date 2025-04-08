package lyx.lc.c5;

import java.util.Arrays;

/**
 * 567. 字符串的排列
 */
public class Lc0567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        char[] c1 = s1.toCharArray();
        int[] count1 = new int[26];
        for (char c : c1) {
            count1[c - 'a']++;
        }
        int k = c1.length;
        char[] c2 = s2.toCharArray();
        int[] count2 = new int[26];
        for (int i = 0; i < k - 1; i++) {
            count2[c2[i] - 'a']++;
        }
        for (int i = k - 1; i < c2.length; i++) {
            count2[c2[i] - 'a']++;
            if (Arrays.equals(count1, count2)) {
                return true;
            }
            count2[c2[i - k + 1] - 'a']--;
        }
        return false;
    }
}
