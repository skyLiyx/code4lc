package com.lynx.algo.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 前缀树。
 *
 * @apiNote
 * Trie（前缀树） 是一种树形数据结构，用于高效存储和检索字符串集合。它的核心思想是
 * 通过共享公共前缀来减少存储空间，并支持快速的前缀匹配操作。核心概念：<p>
 * 节点结构：
 * <pre>
 *     - 每个节点表示一个字符。
 *     - 子节点指针（如 nexts）指向下一层字符。
 *     - 标记是否为单词结尾（如 end）。
 * </pre>
 * 根节点：
 * <pre>
 *     - 根节点为空字符，作为所有字符串的起点。
 * </pre>
 * 更多信息详见：<a href="https://oi-wiki.org/string/trie/">
 *     字典树 (Trie) - OI Wiki</a>
 */
public class Trie {

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

    private final TrieNode root;

    public Trie(){
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
    public int prefixNumber(String prefix) {
        TrieNode node = root;
        for (int i = 0, path; i < prefix.length(); i++) {
            path = prefix.charAt(i);
            if (!node.nexts.containsKey(path)) {
                return 0;
            }
            node = node.nexts.get(path);
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
                path = text.charAt(i);
                if (--node.nexts.get(path).pass == 0) {
                    node.nexts.remove(path);
                    return;
                }
                node = node.nexts.get(path);
            }
            node.end--;
        }
    }
}
