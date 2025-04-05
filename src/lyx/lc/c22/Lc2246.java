package lyx.lc.c22;

import java.util.ArrayList;
import java.util.List;

/**
 * 2246. 相邻字符不同的最长路径
 *
 * @apiNote 树形DP
 */
public class Lc2246 {
    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 1; i < parent.length; i++) {
            graph.get(parent[i]).add(i);
        }
        return f(graph, s.toCharArray(), 0).maxPath;
    }

    private Info f(List<List<Integer>> graph, char[] s, int u) {
        if (graph.get(u).isEmpty()) {
            // 叶子节点
            return new Info(1,1);
        }
        int max1 = 0; // 能连上当前节点的下方第一长路径
        int max2 = 0; // 能连上当前节点的下方第二长路径
        int maxPath = 1; // 当前节点为根节点的树中的最长路径
        for (int v : graph.get(u)) {
            Info info = f(graph, s, v);
            maxPath = Math.max(maxPath, info.maxPath);
            if (s[u] != s[v]) {
                if (info.path > max1) {
                    max2 = max1;
                    max1 = info.path;
                } else if (info.path > max2) {
                    max2 = info.path;
                }
            }
        }
        int path = 1 + max1;
        maxPath = Math.max(maxPath, max1 + 1 + max2);
        return new Info(maxPath, path);
    }

    private static class Info {
        public int maxPath;
        public int path;

        public Info(int maxPath, int path) {
            this.maxPath = maxPath;
            this.path = path;
        }
    }
}
