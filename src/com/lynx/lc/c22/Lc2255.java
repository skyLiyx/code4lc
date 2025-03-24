package com.lynx.lc.c22;

import java.util.Arrays;

/**
 * 2255. 统计是给定字符串前缀的字符串数目
 *
 * @date 2025/03/24
 * @apiNote 字典树
 */
public class Lc2255 {
    private static final int MAXN = 10001;
    private final int[][] tree = new int[MAXN][26];
    private final int[] end = new int[MAXN];
    private int cnt;

    private void build(String[] words) {
        cnt = 1;
        for (String word : words) {
            int cur = 1;
            for (int i = 0; i < word.length(); i++) {
                int next = word.charAt(i) - 'a';
                if (tree[cur][next] == 0) {
                    tree[cur][next] = ++cnt;
                }
                cur = tree[cur][next];
            }
            end[cur]++;
        }
    }

    private void clear() {
        for (int i = 1; i < cnt; i++) {
            Arrays.fill(tree[i], 0);
            end[i] = 0;
        }
    }

    public int countPrefixes(String[] words, String s) {
        build(words);
        int ans = 0;
        int cur = 1;
        for (int i = 0; i < s.length(); i++) {
            int next = s.charAt(i) - 'a';
            if (tree[cur][next] == 0) {
                return ans;
            }
            cur = tree[cur][next];
            ans += end[cur];
        }
        clear();
        return ans;
//        return (int) Arrays.stream(words).filter(s::startsWith).count();
    }
}
