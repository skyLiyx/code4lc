package lyx.lc.c0;

import java.util.*;

/**
 * 17. 电话号码的字母组合
 */
public class Lc0017 {
    private static final Map<Character, List<Character>> map = new HashMap<>();

    static {
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));
    }

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.isEmpty()) {
            return ans;
        }
        dfs(ans, digits, new char[digits.length()], 0);
        return ans;
    }

    private void dfs(List<String> ans, String digits, char[] path, int i) {
        if (i == digits.length()) {
            ans.add(new String(path));
            return;
        }
        for (char c : map.get(digits.charAt(i))) {
            path[i] = c;
            dfs(ans, digits, path, i + 1);
        }
    }
}
