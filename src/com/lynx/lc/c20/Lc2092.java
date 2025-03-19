package com.lynx.lc.c20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2092. 找出知晓秘密的所有专家
 *
 * @apiNote 并查集
 */
public class Lc2092 {
    private static final int MAXN = 100001;
    private final int[] father = new int[MAXN];
    private final boolean[] secret = new boolean[MAXN];

    private void build(int n, int first) {
        for (int i = 0; i < n; i++) {
            father[i] = i;
            secret[i] = false;
        }
        father[first] = 0;
        secret[0] = true;
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
            secret[fb] |= secret[fa];
        }
    }

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        build(n, firstPerson);
        int m = meetings.length;
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);
        for (int l = 0, r; l < m; ) {
            r = l;
            // 首先找出每个时间点的会议，然后合并
            while (r + 1 < m && meetings[r + 1][2] == meetings[l][2]) {
                r++;
            }
            for (int i = l; i <= r; i++) {
                union(meetings[i][0], meetings[i][1]);
            }
            // 如果合并后的代表节点没有知晓秘密，拆散集合
            for (int i = l, a, b; i <= r; i++) {
                a = meetings[i][0];
                b = meetings[i][1];
                if (!secret[find(a)]) {
                    father[a] = a;
                }
                if (!secret[find(b)]) {
                    father[b] = b;
                }
            }
            l = r + 1;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (secret[find(i)]) {
                ans.add(i);
            }
        }
        return ans;
    }
}
