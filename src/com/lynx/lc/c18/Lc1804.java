package com.lynx.lc.c18;

/**
 * 1804.实现Trie（前缀树）
 *
 * @see com.lynx.algo.string.Trie
 */
public class Lc1804 {

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
            node.pass++;
            for (int i = 0, path; i < text.length(); i++) {
                path = text.charAt(i) - 'a';
                if (node.nexts[path] == null) {
                    node.nexts[path] = new TrieNode();
                }
                node = node.nexts[path];
                node.pass++;
            }
            node.end++;
        }

        /**
         * 查找字符串出现次数。
         */
        public int search(String text) {
            TrieNode node = root;
            for (int i = 0, path; i < text.length(); i++) {
                path = text.charAt(i) - 'a';
                if (node.nexts[path] == null) {
                    return 0;
                }
                node = node.nexts[path];
            }
            return node.end;
        }

        /**
         * 查找前缀出现次数。
         */
        public int prefixNumber(String prefix) {
            TrieNode node = root;
            for (int i = 0, path; i < prefix.length(); i++) {
                path = prefix.charAt(i) - 'a';
                if (node.nexts[path] == null) {
                    return 0;
                }
                node = node.nexts[path];
            }
            return node.pass;
        }

        /**
         * 移除一个字符串。
         */
        public void delete(String text) {
            if (search(text) > 0) {
                TrieNode node = root;
                node.pass--;
                for (int i = 0, path; i < text.length(); i++) {
                    path = text.charAt(i) - 'a';
                    if (--node.nexts[path].pass == 0) {
                        node.nexts[path] = null;
                        return;
                    }
                    node = node.nexts[path];
                }
                node.end--;
            }
        }
    }

    static class TrieNode {
        public int pass;
        public int end;
        public TrieNode[] nexts;

        public TrieNode() {
            pass = 0;
            end = 0;
            nexts = new TrieNode[26];
        }
    }
}
