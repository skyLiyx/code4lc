package com.lynx.lc.c0;

import java.util.*;

/**
 * 49. 字母异位词分组
 */
public class Lc0049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            // 通过统计词频，异位词之间得出相同的编码
            // 另一种编码方式就是转成字符数组后直接排序
            char[] count = new char[26];
            char[] arr = str.toCharArray();
            for (char c : arr) {
                count[c - 'a']++;
            }
            map.computeIfAbsent(new String(count), k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
