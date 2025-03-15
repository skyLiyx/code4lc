package com.lynx.lc.c2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 212.单词搜索 II
 *
 * @apiNote 前缀树
 */
public class Lc0212 {
    private static int m;

    private static int n;

    public List<String> findWords(char[][] board, String[] words) {
        m = board.length;
        n = board[0].length;
        build(words);
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(ans, board, i, j, 1);
            }
        }
        clear();
        return ans;
    }

    private static final int MAXN = 100001;

    private static final int[][] TREE = new int[MAXN][26];

    private static final int[] PASS = new int[MAXN];

    private static final String[] END = new String[MAXN];

    private static int cnt;

    private void build(String[] words) {
        cnt = 1;
        for (String word : words) {
            int cur = 1;
            PASS[cur]++;
            for (int i = 0, path; i < word.length(); i++) {
                path = word.charAt(i) - 'a';
                if (TREE[cur][path] == 0) {
                    TREE[cur][path] = ++cnt;
                }
                cur = TREE[cur][path];
                PASS[cur]++;
            }
            END[cur] = word;
        }
    }

    private void dfs(List<String> ans, char[][] board, int i, int j, int cur) {
        if (i >= m || i < 0 || j >= n || j < 0 || board[i][j] == '0') {
            return;
        }
        int path = board[i][j] - 'a';
        if (TREE[cur][path] == 0) {
            return;
        }
        if (END[TREE[cur][path]] != null) {
            ans.add(END[TREE[cur][path]]);
            // 找到后删除，避免后续重复查找
            delete(END[TREE[cur][path]]);
            END[TREE[cur][path]] = null;
            // 此处不要return，继续往下找，退出条件只能是上面的情况
        }
        char temp = board[i][j];
        board[i][j] = '0';
        dfs(ans, board, i - 1, j, TREE[cur][path]);
        dfs(ans, board, i + 1, j, TREE[cur][path]);
        dfs(ans, board, i, j - 1, TREE[cur][path]);
        dfs(ans, board, i, j + 1, TREE[cur][path]);
        board[i][j] = temp;
    }

    private void delete(String word) {
        int cur = 1;
        for (int i = 0, path; i < word.length(); i++) {
            path = word.charAt(i) - 'a';
            if (--PASS[TREE[cur][path]] == 0) {
                TREE[cur][path] = 0;
                return;
            }
            cur = TREE[cur][path];
        }
        END[cur] = null;
    }

    private void clear() {
        for (int i = 1; i <= cnt; i++) {
            Arrays.fill(TREE[i], 0);
            PASS[i] = 0;
            END[i] = null;
        }
    }
}
