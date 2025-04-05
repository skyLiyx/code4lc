package lyx.lc.c2;

import java.util.HashMap;
import java.util.Map;

/**
 * 208. 实现 Trie (前缀树)
 */
public class Lc0208 {

    private static class TrieNode {
        public int pass;
        public int end;
        Map<Integer, TrieNode> nexts;

        public TrieNode() {
            pass = 0;
            end = 0;
            nexts = new HashMap<>();
        }
    }


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
                path = text.charAt(i);
                if (!node.nexts.containsKey(path)) {
                    node.nexts.put(path, new TrieNode());
                }
                node = node.nexts.get(path);
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
                path = text.charAt(i);
                if (!node.nexts.containsKey(path)) {
                    return 0;
                }
                node = node.nexts.get(path);
            }
            return node.end;
        }

        /**
         * 查找前缀出现次数。
         */
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (int i = 0, path; i < prefix.length(); i++) {
                path = prefix.charAt(i);
                if (!node.nexts.containsKey(path)) {
                    return false;
                }
                node = node.nexts.get(path);
            }
            return true;
        }
    }
}