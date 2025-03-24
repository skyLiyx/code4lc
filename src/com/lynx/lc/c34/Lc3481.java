package com.lynx.lc.c34;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 3481. 应用替换
 */
public class Lc3481 {
    public String applySubstitutions(List<List<String>> replacements, String text) {
        Map<Character, String> map = new HashMap<>();
        for (List<String> r : replacements) {
            map.put(r.get(0).charAt(0), r.get(1));
        }
        StringBuilder sb = new StringBuilder(text);
        int p = 0;
        while (p < sb.length()) {
            if (sb.charAt(p) == '%') {
                if (p + 2 > sb.length() || sb.charAt(p + 2) != '%') {
                    continue;
                }
                if (sb.charAt(p + 1) >= 'A' && sb.charAt(p + 1) <= 'Z') {
                    sb.replace(p, p + 3, map.get(sb.charAt(p + 1)));
                }
            } else {
                p++;
            }
        }
        return sb.toString();
    }
}
