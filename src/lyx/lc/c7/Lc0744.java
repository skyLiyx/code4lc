package lyx.lc.c7;

/**
 * 744. 寻找比目标字母大的最小字母
 */
public class Lc0744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int ans = -1;
        int l = 0, r = letters.length - 1, m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (letters[m] > target) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans == -1 ? letters[0] : letters[ans];
    }
}
