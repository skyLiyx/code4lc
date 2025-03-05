package com.lynx.lc.c13;

/**
 * 1328.破坏回文串
 *
 * @date 2025/03/05
 */
public class Lc1328 {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if (n == 1) {
            return "";
        }
        char[] arr = palindrome.toCharArray();
        int p1 = 0, p2 = n - 1;
        while (p1 <= p2 && arr[p1] == 'a') {
            p1++;
            p2--;
        }
        if (p1 < p2) {
            arr[p1] = 'a';
        } else {
            arr[n - 1] = 'b';
        }
        return new String(arr);
    }
}
