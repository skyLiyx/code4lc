package lyx.lc.c2;

import java.util.Arrays;

/**
 * 207. 课程表
 *
 * @apiNote 拓扑排序
 */
public class Lc0207 {
    private static final int MAXN = 5001;

    private final int[] head = new int[MAXN];

    private final int[] next = new int[MAXN];

    private final int[] to = new int[MAXN];

    private int cnt;

    private final int[] queue = new int[MAXN];
    private int l, r;

    private final int[] indegree = new int[MAXN];

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        l = r = 0;
        cnt = 1;
        Arrays.fill(head, 1, numCourses + 1, 0);
        Arrays.fill(indegree, 1, numCourses + 1, 0);
        for (int[] p : prerequisites) {
            next[cnt] = head[p[1]];
            to[cnt] = p[0];
            head[p[1]] = cnt++;
            indegree[p[0]]++;
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue[r++] = i;
            }
        }
        int fill = 0;
        while (l < r) {
            int cur = queue[l++];
            fill++;
            for (int e = head[cur]; e > 0; e = next[e]) {
                if (--indegree[to[e]] == 0) {
                    queue[r++] = to[e];
                }
            }
        }
        return fill == numCourses;
    }
}
