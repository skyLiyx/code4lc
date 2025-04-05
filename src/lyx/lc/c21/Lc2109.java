package lyx.lc.c21;

/**
 * 2109. 向字符串添加空格
 *
 * @date 2025/03/30
 */
public class Lc2109 {
    public String addSpaces(String s, int[] spaces) {
        char[] s1 = s.toCharArray();
        int m = s1.length;
        int n = spaces.length;
        char[] s2 = new char[m + n];
        for (int i = 0, j = 0, k = 0; i < m; ) {
            if (j < n && i == spaces[j]) {
                s2[k++] = ' ';
                j++;
            } else {
                s2[k++] = s1[i++];
            }
        }
        return new String(s2);
    }
}
