package com.lynx.lc.c33;

import java.util.Arrays;
import java.util.List;

/**
 * 3305.元音辅音字符串计数
 *
 * @date 2025/03/12
 */
public class Lc3305 {
    private static final List<Character> VOWELS = Arrays.asList('a', 'e', 'i', 'o', 'u');

    public int countOfSubstrings(String word, int k) {
        int ans = 0;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            for (int j = n - i; j >= k + 5; j--) {
                if (check(word, k, i, i + j - 1)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private boolean check(String s, int k, int begin, int end) {
        int maskVowel = 0, idx;
        int consonants = 0;
        while (begin <= end) {
            if ((idx = VOWELS.indexOf(s.charAt(begin))) != -1) {
                maskVowel |= (1 << idx);
            } else {
                consonants++;
            }
            if (consonants > k) {
                return false;
            }
            begin++;
        }
        return maskVowel == 0b11111 && consonants == k;
    }
}
