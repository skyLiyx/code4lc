package lyx.lc.c22;

/**
 * 2278. 字母在字符串中的百分比
 *
 * @date 2025/03/31
 */
public class Lc2278 {
    public int percentageLetter(String s, char letter) {
        char[] arr = s.toCharArray();
        int ans = 0;
        for (char c : arr) {
            if (c == letter) ans++;
        }
        return ans * 100 / arr.length;
    }
}
