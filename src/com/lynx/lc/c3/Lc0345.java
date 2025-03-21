package com.lynx.lc.c3;

/**
 * 345. 反转字符串中的元音字母
 */
public class Lc0345 {
    public String reverseVowels(String s) {
        boolean[] vowels = new boolean[128];
        vowels['a'] = true;
        vowels['e'] = true;
        vowels['i'] = true;
        vowels['o'] = true;
        vowels['u'] = true;
        vowels['A'] = true;
        vowels['E'] = true;
        vowels['I'] = true;
        vowels['O'] = true;
        vowels['U'] = true;
        char[] arr = s.toCharArray();
        int l = 0, r = arr.length - 1;
        while (l < r) {
            if (!vowels[arr[l]]) {
                l++;
            } else if (!vowels[arr[r]]) {
                r--;
            } else {
                swap(arr, l++, r--);
            }
        }
        return new String(arr);
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
