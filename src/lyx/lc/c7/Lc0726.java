package lyx.lc.c7;

import java.util.Map;
import java.util.TreeMap;

/**
 * 726.原子的数量
 */
public class Lc0726 {
    private int where;

    public String countOfAtoms(String formula) {
        where = 0;
        Map<String, Integer> map = countOfAtoms0(formula.toCharArray(), 0);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int n = entry.getValue();
            sb.append(entry.getKey()).append(n == 1 ? "" : n);
        }
        return sb.toString();
    }

    private Map<String, Integer> countOfAtoms0(char[] s, int i) {
        Map<String, Integer> ans = new TreeMap<>();
        Map<String, Integer> pre = null;
        StringBuilder name = new StringBuilder();
        int cnt = 0;
        while (i < s.length && s[i] != ')') {
            if (s[i] >= 'A' && s[i] <= 'Z' || s[i] == '(') {
                fill(ans, pre, name, cnt);
                name.setLength(0);
                pre = null;
                cnt = 0;
                if (s[i] == '(') {
                    pre = countOfAtoms0(s, i + 1);
                    i = where + 1;
                } else {
                    name.append(s[i++]);
                }
            } else if (s[i] >= 'a' && s[i] <= 'z') {
                name.append(s[i++]);
            } else {
                cnt = cnt * 10 + (s[i++] - '0');
            }
        }
        fill(ans, pre, name, cnt);
        where = i;
        return ans;
    }

    private void fill(Map<String, Integer> ans, Map<String, Integer> pre, StringBuilder name, int cnt) {
        if (name.length() > 0 || pre != null) {
            cnt = cnt == 0 ? 1 : cnt;
            if (name.length() > 0) {
                String key = name.toString();
                ans.put(key, ans.getOrDefault(key, 0) + cnt);
            } else {
                for (String key : pre.keySet()) {
                    ans.put(key, ans.getOrDefault(key, 0) + pre.get(key) * cnt);
                }
            }
        }
    }
}
