package com.lynx.lc.c2;

import java.util.ArrayList;
import java.util.List;

/**
 * 210. 课程表 II
 *
 * @apiNote 拓扑排序
 */
public class Lc0210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int[] in = new int[numCourses];
        for (int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]);
            in[p[0]]++;
        }
        int[] queue = new int[numCourses];
        int l = 0, r = 0;
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) {
                queue[r++] = i;
            }
        }
        int[] ans = new int[numCourses];
        int index = 0;
        while (l < r) {
            int cur = queue[l++];
            for (int next : graph.get(cur)) {
                if (--in[next] == 0) {
                    queue[r++] = next;
                }
            }
            ans[index++] = cur;
        }
        return index != numCourses ? new int[]{} : ans;
    }
}
