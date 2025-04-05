package lyx.lc.c0;

import java.util.Arrays;

/**
 * 14. 最长公共前缀
 */
public class Lc0014 {
    /**
     * 字典树.
     */
    public String longestCommonPrefix(String[] strs) {
        build(strs);
        char[] s = strs[0].toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0, cur = 1; i < s.length; i++) {
            cur = tree[cur][s[i] - 'a'];
            if (pass[cur] == strs.length) {
                sb.append(s[i]);
            } else {
                break;
            }
        }
        clear();
        return sb.toString();
    }

    /**
     * 暴力方法.
     */
    public String longestCommonPrefix1(String[] strs) {
        char[] arr = strs[0].toCharArray();
        int len = 0;
        while (len < arr.length) {
            boolean eq = true;
            for (int i = 1; i < strs.length; i++) {
                if (len >= strs[i].length() || strs[i].charAt(len) != arr[len]) {
                    eq = false;
                    break;
                }
            }
            if (!eq) {
                break;
            }
            len++;
        }
        return String.valueOf(arr, 0, len);
    }

    private static final int[][] tree = new int[40001][26];
    private static final int[] pass = new int[40001];
    private static int cnt = 1;

    private static void build(String[] words) {
        cnt = 1;
        for (String word : words) {
            insert(word);
        }
    }

    private static void clear() {
        for (int i = 1; i <= cnt; i++) {
            Arrays.fill(tree[i], 0);
            pass[i] = 0;
        }
    }

    private static void insert(String word) {
        int cur = 1;
        pass[cur]++;
        char[] arr = word.toCharArray();
        for (int i = 0, path; i < arr.length; i++) {
            path = arr[i] - 'a';
            if (tree[cur][path] == 0) {
                tree[cur][path] = ++cnt;
            }
            cur = tree[cur][path];
            pass[cur]++;
        }
    }
}
