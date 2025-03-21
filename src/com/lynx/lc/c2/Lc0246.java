package com.lynx.lc.c2;

/**
 * 246. 中心对称数
 */
public class Lc0246 {
    public boolean isStrobogrammatic(String num) {
        int l = 0, r = num.length() - 1;
        while (l < r) {
            char lc = num.charAt(l);
            char rc = num.charAt(r);
            if (lc != rc) {
                if (!(lc == '6' && rc == '9') && !(lc == '9' && rc == '6')) {
                    return false;
                }
            } else {
                if (lc != '0' && lc != '1' && lc != '8') {
                    return false;
                }
            }
            l++;
            r--;
        }
        if (l == r) {
            return num.charAt(l) == '0' || num.charAt(l) == '1' || num.charAt(l) == '8';
        }
        return true;
    }
}
