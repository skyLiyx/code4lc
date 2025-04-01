package com.lynx.lc.c0;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. 罗马数字转整数
 */
public class Lc0013 {
    private static final Map<String, Integer> map = new HashMap<>();

    static {
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
    }

    public int romanToInt(String s) {
        int n = s.length();
        int i = 0;
        int ans = 0;
        String key;
        while (i < n) {
            if (i + 1 < n && map.containsKey((key = s.substring(i, i + 2)))) {
                ans += map.get(key);
                i += 2;
            } else {
                ans += map.get(s.substring(i, ++i));
            }
        }
        return ans;
    }
}
