package com.lynx.lc.c3;

/**
 * 383. 赎金信
 */
public class Lc0383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }
        int kind = 0;
        int[] count = new int[26];
        for (char c : ransomNote.toCharArray()) {
            if (count[c - 'a']++ == 0) {
                kind++;
            }
        }
        for (char c : magazine.toCharArray()) {
            if (--count[c - 'a'] == 0) {
                kind--;
            }
        }
        return kind == 0;
    }
}
