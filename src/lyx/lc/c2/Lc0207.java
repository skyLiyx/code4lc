package lyx.lc.c2;

import java.util.Arrays;

/**
 * 207. 课程表
 *
 * @apiNote 拓扑排序
 */
public class Lc0207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        build(numCourses);
        for (int[] prerequisite : prerequisites) {
            addEdge(prerequisite[1], prerequisite[0]);
            indegree[prerequisite[0]]++;
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue[r++] = i;
            }
        }
        int fill = 0;
        while (l < r) {
            int u = queue[l++];
            fill++;
            for (int ei = head[u]; ei > 0; ei = next[ei]) {
                int v = to[ei];
                if (--indegree[v] == 0) {
                    queue[r++] = v;
                }
            }
        }
        return fill == numCourses;
    }

    private static final int MAXN = 2001;

    private static final int MAXM = 5001;

    private static final int[] head = new int[MAXN];

    private static final int[] next = new int[MAXM];

    private static final int[] to = new int[MAXM];

    private static int cnt;

    private static final int[] indegree = new int[MAXN];

    private static final int[] queue = new int[MAXN];

    private static int l, r;

    private void build(int n) {
        Arrays.fill(head, 0, n + 1, 0);
        cnt = 1;
        Arrays.fill(indegree, 0, n + 1, 0);
        l = r = 0;
    }

    private void addEdge(int u, int v) {
        next[cnt] = head[u];
        to[cnt] = v;
        head[u] = cnt++;
    }
}
