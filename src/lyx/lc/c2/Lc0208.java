package lyx.lc.c2;

/**
 * 208. 实现 Trie (前缀树)
 */
public class Lc0208 {

    public static class Trie {

        private final TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        /**
         * 插入字符串。
         */
        public void insert(String text) {
            TrieNode node = root;
            for (int i = 0, path; i < text.length(); i++) {
                path = text.charAt(i) - 'a';
                if (node.next[path] == null) {
                    node.next[path] = new TrieNode();
                }
                node = node.next[path];
            }
            node.end++;
        }

        /**
         * 查找字符串出现次数。
         */
        public boolean search(String text) {
            TrieNode node = root;
            for (int i = 0, path; i < text.length(); i++) {
                path = text.charAt(i) - 'a';
                if (node.next[path] == null) {
                    return false;
                }
                node = node.next[path];
            }
            return node.end != 0;
        }

        /**
         * 查找前缀出现次数。
         */
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (int i = 0, path; i < prefix.length(); i++) {
                path = prefix.charAt(i) - 'a';
                if (node.next[path] == null) {
                    return false;
                }
                node = node.next[path];
            }
            return true;
        }

        private static class TrieNode {
            public int end;
            public TrieNode[] next;

            public TrieNode() {
                end = 0;
                // 如果字符不确定，可以改为map
                next = new TrieNode[26];
            }
        }
    }
}