package lyx.lc.c2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 269. 火星词典
 *
 * @apiNote 拓扑排序
 */
public class Lc0269 {
    private static final int MAXN = 26;

    private final int[] indegree = new int[MAXN];

    private final int[] queue = new int[MAXN];

    public String alienOrder(String[] words) {
        Arrays.fill(indegree, -1);
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                indegree[word.charAt(i) - 'a'] = 0;
            }
        }
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < MAXN; i++) {
            graph.add(new ArrayList<>());
        }
        int n = words.length;
        for (int i = 0, j, len; i < n - 1; i++) {
            String cur = words[i];
            String next = words[i + 1];
            len = Math.min(cur.length(), next.length());
            for (j = 0; j < len; j++) {
                if (cur.charAt(j) != next.charAt(j)) {
                    int from = cur.charAt(j) - 'a';
                    int to = next.charAt(j) - 'a';
                    graph.get(from).add(to);
                    indegree[to]++;
                    break;
                }
            }
            if (j < cur.length() && j == next.length()) {
                return "";
            }
        }
        int l = 0, r = 0, kinds = 0;
        for (int i = 0; i < 26; i++) {
            if (indegree[i] != -1) {
                kinds++;
            }
            if (indegree[i] == 0) {
                queue[r++] = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (l < r) {
            int cur = queue[l++];
            sb.append((char)(cur + 'a'));
            for (int next : graph.get(cur)) {
                if (--indegree[next] == 0) {
                    queue[r++] = next;
                }
            }
        }
        return sb.length() != kinds ? "" : sb.toString();
    }
}
