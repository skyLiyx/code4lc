package lyx.lc.c3;

/**
 * 389. 找不同
 */
public class Lc0389 {
    public char findTheDifference(String s, String t) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            if (--count[c - 'a'] == -1) {
                return c;
            }
        }
        return 0;
    }
}
