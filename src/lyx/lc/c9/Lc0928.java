package lyx.lc.c9;

import java.util.Arrays;

/**
 * 928. 尽量减少恶意软件的传播 II
 *
 * @apiNote 并查集
 */
public class Lc0928 {
    private static final int MAXN = 301;

    private final int[] father = new int[MAXN];

    private final int[] size = new int[MAXN];

    // 代表节点的感染点，-1表示没有，-2表示超过一个感染点，其他表示感染节点
    private final int[] infect = new int[MAXN];

    // 是否感染点
    private final boolean[] virus = new boolean[MAXN];

    // 当前感染点切断后能拯救的数量
    private final int[] cnts = new int[MAXN];

    private void build(int n, int[] initial) {
        for (int i = 0; i < n; i++) {
            father[i] = i;
            size[i] = 1;
            infect[i] = -1;
            virus[i] = false;
            cnts[i] = 0;
        }
        for (int i : initial) {
            virus[i] = true;
        }
    }

    private int find(int i) {
        if (i != father[i]) {
            father[i] = find(father[i]);
        }
        return father[i];
    }

    private void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) {
            father[fa] = fb;
            size[fb] += size[fa];
        }
    }

    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n = graph.length;
        build(n, initial);
        // 先把所有正常的节点合并
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1 && !virus[i] && !virus[j]) {
                    // 两个节点相连且都不是感染点
                    union(i, j);
                }
            }
        }
        // 找出与感染节点相连的集合
        for (int i : initial) {
            for (int neighbor = 0; neighbor < n; neighbor++) {
                if (neighbor != i && !virus[neighbor] && graph[neighbor][i] == 1) {
                    int fa = find(neighbor);
                    if (infect[fa] == -1) {
                        // 如果当前集合没有被感染，设置其感染源节点
                        infect[fa] = i;
                    } else if (infect[fa] != -2 && infect[fa] != i) {
                        // 如果当前集合已经被感染且超过1个源节点，
                        // 或已有的1个源节点不是当前源节点
                        infect[fa] = -2;
                    }
                }
            }
        }
        // 分别统计每个感染点断开能拯救的数量
        for (int i = 0; i < n; i++) {
            if (i == find(i) && infect[i] > -1) {
                cnts[infect[i]] += size[i];
            }
        }
        // 找出最多且最小的感染点
        Arrays.sort(initial);
        int ans = initial[0];
        int max = cnts[ans];
        for (int i : initial) {
            if (cnts[i] > max) {
                max = cnts[i];
                ans = i;
            }
        }
        return ans;
    }
}
