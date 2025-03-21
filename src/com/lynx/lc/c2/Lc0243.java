package com.lynx.lc.c2;

/**
 * 243. 最短单词距离
 */
public class Lc0243 {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int n = wordsDict.length;
        int ans = n - 1;
        int p1 = -1, p2 = -1;
        for (int i = 0; i < n; i++) {
            if (wordsDict[i].equals(word1)) {
                p1 = i;
            }
            if (wordsDict[i].equals(word2)) {
                p2 = i;
            }
            if (p1 != -1 && p2 != -1) {
                ans = Math.min(ans, Math.abs(p1 - p2));
            }
        }
        return ans;
    }
}
