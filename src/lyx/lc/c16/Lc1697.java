package lyx.lc.c16;

import java.util.Arrays;

/**
 * 1697. 检查边长度限制的路径是否存在
 *
 * @apiNote 最小生成树
 */
public class Lc1697 {
    private static final int MAXN = 100001;

    private static final int[] father = new int[MAXN];

    private static final int[][] questions = new int[MAXN][4];

    private void build(int n) {
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }

    private int find(int i) {
        if (i != father[i]) {
            father[i] = find(father[i]);
        }
        return father[i];
    }

    private boolean isSameSet(int a, int b) {
        return find(a) == find(b);
    }

    private void union(int a, int b) {
        father[find(a)] = find(b);
    }

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        // 边按权值从小到大排序
        Arrays.sort(edgeList, (e1, e2) -> e1[2] - e2[2]);
        int m = edgeList.length;
        int k = queries.length;
        for (int i = 0; i < k; i++) {
            questions[i][0] = queries[i][0];
            questions[i][1] = queries[i][1];
            questions[i][2] = queries[i][2];
            questions[i][3] = i;
        }
        // 查询按限定值从小到大排序
        Arrays.sort(questions, 0, k, (q1, q2) -> q1[2] - q2[2]);
        build(n);
        boolean[] ans = new boolean[k];
        for (int i = 0, j = 0; i < k; i++) {
            for (; j < m && edgeList[j][2] < questions[i][2]; j++) {
                union(edgeList[j][0], edgeList[j][1]);
            }
            ans[questions[i][3]] = isSameSet(questions[i][0], questions[i][1]);
        }
        return ans;
    }
}
