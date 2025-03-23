package com.lynx.lc.c0;

/**
 * 67. 二进制求和
 */
public class Lc0067 {
    public String addBinary(String a, String b) {
        int n = a.length(), m = b.length();
        int max = Math.max(m, n);
        StringBuilder sb = new StringBuilder();
        int p = 0, add = 0;
        while (p < max) {
            // 从右往左处理，超出部分用'0'替代
            char c1 = n - 1 - p < 0 ? '0' : a.charAt(n - 1 - p);
            char c2 = m - 1 - p < 0 ? '0' : b.charAt(m - 1 - p);
            if (c1 == c2) {
                // 都是0或都是1
                sb.insert(0, add);
                add = c1 == '1' ? 1 : 0;
            } else {
                // 一个0一个1
                sb.insert(0, add == 1 ? 0 : 1);
                // 进位信息维持不变，有进位还是有进位，无进位还是无进位
            }
            p++;
        }
        if (add == 1) {
            // 处理完还是存在进位，在最开头加1
            sb.insert(0, 1);
        }
        return sb.toString();
    }
}
