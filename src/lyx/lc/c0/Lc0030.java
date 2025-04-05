package lyx.lc.c0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 30. 串联所有单词的子串
 */
public class Lc0030 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int n = s.length();
        int m = words.length;
        int len = words[0].length();
        if (n < m * len) {
            return ans;
        }
        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word : words) {
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }
        Map<String, Integer> map = new HashMap<>();
        String substr;
        for (int i = 0, l, r; i < len; i++) {
            // 窗口边界在 i + len * n，边界移动距离都是len
            // 控制i在[0,len)范围，就可以确保覆盖所有下标
            l = r = i;
            while (l <= n - m * len) {
                // 窗口内保证每len个长度的字符串都是words中的
                // 扩充右边界
                while (r + len <= n && wordsMap.containsKey((substr = s.substring(r, r + len)))) {
                    r += len;
                    map.put(substr, map.getOrDefault(substr, 0) + 1);
                    // 同时保证子串数量也匹配
                    while (map.get(substr) > wordsMap.get(substr)) {
                        map.computeIfPresent(s.substring(l, l + len), (k, v) -> v - 1);
                        l += len;
                    }
                    if (map.equals(wordsMap)) {
                        ans.add(l);
                    }
                }
                // 右边界无法匹配，废弃当前窗口
                // 这里不考虑右移一个位置继续匹配，由外层for循环保证
                map.clear();
                l = r + len;
                r = l;
            }
        }
        return ans;
    }
}
