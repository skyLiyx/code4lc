package lyx.lc.c0;

import java.util.HashMap;
import java.util.Map;

/**
 * 20. 有效的括号
 */
public class Lc0020 {

    private static final Map<Character, Character> map = new HashMap<>();

    static {
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
    }

    public boolean isValid(String s) {
        int n = s.length();
        if ((n & 1) == 1) {
            return false;
        }
        char[] arr = s.toCharArray();
        char[] stack = new char[n];
        int size = 0;
        for (char c : arr) {
            if (c == '(' || c == '[' || c == '{') {
                stack[size++] = c;
            } else {
                if (size == 0 || stack[size - 1] != map.get(c)) {
                    return false;
                }
                size--;
            }
        }
        return size == 0;
    }
}
