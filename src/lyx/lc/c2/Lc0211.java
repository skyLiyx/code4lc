package lyx.lc.c2;

/**
 * 211. 添加与搜索单词 - 数据结构设计
 *
 * @apiNote 字典树
 */
public class Lc0211 {

    public static class WordDictionary {

        private final TrieNode root;

        public WordDictionary() {
            root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode cur = root;
            for (int i = 0, path; i < word.length(); i++) {
                path = word.charAt(i) - 'a';
                if (cur.next[path] == null) {
                    cur.next[path] = new TrieNode();
                }
                cur = cur.next[path];
            }
            cur.isEnd = true;
        }

        public boolean search(String word) {
            char[] arr = word.toCharArray();
            return dfs(root, arr, 0);
        }

        private boolean dfs(TrieNode cur, char[] arr, int i) {
            if (cur == null) {
                return false;
            }
            if (i == arr.length) {
                return cur.isEnd;
            }
            if (arr[i] == '.') {
                for (int j = 0; j < 26; j++) {
                    if (dfs(cur.next[j], arr, i + 1)) {
                        return true;
                    }
                }
                return false;
            } else {
                int path = arr[i] - 'a';
                return dfs(cur.next[path], arr, i + 1);
            }
        }

        private static class TrieNode {
            public boolean isEnd;
            public TrieNode[] next;

            public TrieNode() {
                this.next = new TrieNode[26];
            }
        }
    }
}
