package lyx.lc.c7;

import java.util.ArrayList;
import java.util.List;

/**
 * 745. 前缀和后缀搜索
 *
 * @apiNote 字典树。使用两个字典树，分别存字符串的正序和逆序，字典树每个位置都存下当前字符串的下标。
 * 查询时，在找到前后缀的两个字典树之后，在两个集合之中找交集，这就是同时拥有指定前缀和后缀的字符串。
 */
public class Lc0745 {

    public static class WordFilter {

        private final TrieNode root1;
        private final TrieNode root2;

        public WordFilter(String[] words) {
            root1 = new TrieNode();
            root2 = new TrieNode();
            for (int i = 0; i < words.length; i++) {
                insert(words[i], i);
            }
        }

        private void insert(String word, int index) {
            TrieNode cur = root1;
            for (int i = 0; i < word.length(); i++) {
                int path = word.charAt(i) - 'a';
                if (cur.next[path] == null) {
                    cur.next[path] = new TrieNode();
                }
                cur = cur.next[path];
                cur.list.add(index);
            }
            cur = root2;
            for (int i = word.length() - 1; i >= 0; i--) {
                int path = word.charAt(i) - 'a';
                if (cur.next[path] == null) {
                    cur.next[path] = new TrieNode();
                }
                cur = cur.next[path];
                cur.list.add(index);
            }
        }

        public int f(String pref, String suff) {
            TrieNode cur = root1;
            for (int i = 0; i < pref.length(); i++) {
                int path = pref.charAt(i) - 'a';
                if (cur.next[path] == null) {
                    return -1;
                }
                cur = cur.next[path];
            }
            List<Integer> list1 = cur.list;
            cur = root2;
            for (int i = suff.length() - 1; i >= 0; i--) {
                int path = suff.charAt(i) - 'a';
                if (cur.next[path] == null) {
                    return -1;
                }
                cur = cur.next[path];
            }
            List<Integer> list2 = cur.list;
            for (int i = list1.size() - 1, j = list2.size() - 1; i >= 0 && j >= 0; ) {
                if (list1.get(i) > list2.get(j)) {
                    i--;
                } else if (list1.get(i) < list2.get(j)) {
                    j--;
                } else {
                    return list1.get(i);
                }
            }
            return -1;
        }

        private static class TrieNode {
            public TrieNode[] next;
            public List<Integer> list;

            public TrieNode() {
                this.next = new TrieNode[26];
                this.list = new ArrayList<>();
            }
        }
    }
}
