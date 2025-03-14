package com.lynx.lc.c33;

/**
 * 3340. 检查平衡字符串
 *
 * @date 2025/03/14
 */
public class Lc3340 {
    public boolean isBalanced(String num) {
        int a = 0, b = 0;
        for (int i = 0; i < num.length(); i++) {
            if ((i & 1) == 0) {
                a += num.charAt(i) - '0';
            } else {
                b += num.charAt(i) - '0';
            }
        }
        return a == b;
    }
}
