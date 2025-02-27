package com.lynx.lc.c0;

import com.lynx.algorithm.string.Manacher;

/**
 * 5.最长回文子串
 *
 * @see Manacher
 */
public class Lc0005 {

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        return Manacher.longestPalindrome(s);
    }
}
