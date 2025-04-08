package lyx.lc.c10;

import java.util.HashSet;
import java.util.Set;

/**
 * 1016. 子串能表示从 1 到 N 数字的二进制串
 */
public class Lc1016 {
    public boolean queryString(String s, int n) {
        Set<Integer> set = new HashSet<>();
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            int x = c[i] - '0';
            if (x == 0) continue;
            for (int j = i + 1; x <= n; j++) {
                set.add(x);
                if (j == c.length) break;
                x = (x << 1) | (c[j] - '0');
            }
        }
        return set.size() == n;
    }
}
