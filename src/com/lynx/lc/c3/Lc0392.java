package com.lynx.lc.c3;

/**
 * 392.字符串解码
 */
public class Lc0392 {
    private int where;

    public String decodeString(String s) {
        where = 0;
        return decodeString0(s.toCharArray(), 0).toString();
    }

    private StringBuilder decodeString0(char[] s, int i) {
        StringBuilder sb = new StringBuilder();
        int n = 0;
        while (i < s.length && s[i] != ']') {
            if (s[i] >= 'a' && s[i] <= 'z') {
                sb.append(s[i++]);
            } else if (s[i] >= '0' && s[i] <= '9'){
                n = n * 10 + (s[i++] - '0');
            } else {
                StringBuilder cur = decodeString0(s, i + 1);
                for (int j = 0; j < n; j++) {
                    sb.append(cur);
                }
                i = where + 1;
                n = 0;
            }
        }
        where = i;
        return sb;
    }
}
