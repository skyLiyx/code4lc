package lyx.lc.c29;

/**
 * 2904. 最短且字典序最小的美丽子字符串
 */
public class Lc2904 {
    public String shortestBeautifulSubstring(String s, int k) {
        char[] c = s.toCharArray();
        int count = 0;
        int ans = c.length + 1;
        int startPos = -1;
        for (int l = 0, r = 0; r < c.length; r++) {
            if (c[r] == '1') {
                count++;
            }
            if (count < k) {
                continue;
            }
            while (count > k || c[l] == '0') {
                if (c[l++] == '1') {
                    count--;
                }
            }
            if (r - l + 1 < ans) {
                ans = r - l + 1;
                startPos = l;
            }
            if (r - l + 1 == ans &&  String.valueOf(c, l, ans).compareTo(String.valueOf(c, startPos, ans)) < 0) {
                startPos = l;
            }
        }
        return startPos == -1 ? "" : s.substring(startPos, startPos + ans);
    }
}
