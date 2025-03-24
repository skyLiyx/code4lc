package com.lynx.lc.c1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 127. 单词接龙
 *
 * @apiNote 双向广搜
 */
public class Lc0127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return 0;
        }
        Set<String> smallLevel = new HashSet<>();
        Set<String> bigLevel = new HashSet<>();
        smallLevel.add(beginWord);
        bigLevel.add(endWord);
        Set<String> nextLevel = new HashSet<>();
        for (int len = 2; !smallLevel.isEmpty(); len++) {
            for (String s : smallLevel) {
                // 遍历小层，找出每个元素修改一个字符后的下一个字母
                char[] arr = s.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    // 尝试修改每一个字符，判断字典中是否存在，然后将其作为下一层数据
                    char old = arr[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c != old) {
                            arr[i] = c;
                            String word = String.valueOf(arr);
                            if (bigLevel.contains(word)) {
                                return len;
                            }
                            if (dict.contains(word)) {
                                nextLevel.add(word);
                                dict.remove(word);
                            }
                        }
                    }
                    arr[i] = old;
                }
            }
            // 判断下一层和较大层的大小，更新大层和小层
            smallLevel.clear();
            if (nextLevel.size() < bigLevel.size()) {
                smallLevel.addAll(nextLevel);
            } else {
                smallLevel.addAll(bigLevel);
                bigLevel.clear();
                bigLevel.addAll(nextLevel);
            }
            nextLevel.clear();
        }
        return 0;
    }
}
