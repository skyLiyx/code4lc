package lyx.lc.c26;

import java.util.Arrays;

/**
 * 2612. 最少翻转操作数
 *
 * @date 2025/03/20
 */
public class Lc2612 {
    private static final int MAXN = 100001;
    private final int[] father = new int[MAXN];
    private final int[] queue = new int[MAXN];

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

    private void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) {
            father[fa] = fb;
        }
    }

    public int[] minReverseOperations(int n, int p, int[] banned, int k) {
        build(n + 2);
        union(p, p + 2);
        for (int i : banned) {
            union(i, i + 2);
        }
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        ans[p] = 0;
        int l = 0, r = 0;
        queue[r++] = p;
        while (l < r) {
            int i = queue[l++];
            int min = Math.max(i - k + 1, k - i - 1);
            int max = Math.min(i + k - 1, n * 2 - k - i - 1);
            for (int j = find(min); j <= max; j = find(j + 2)) {
                ans[j] = ans[i] + 1;
                queue[r++] = j;
                union(j, max + 2);
            }
        }
        return ans;
    }
}
