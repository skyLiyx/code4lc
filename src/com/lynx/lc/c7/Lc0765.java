package com.lynx.lc.c7;

/**
 * 765. 情侣牵手
 *
 * @apiNote 并查集
 */
public class Lc0765 {

    private final int[] father = new int[31];

    private int sets;

    private void build(int n) {
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
        sets = n;
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
            sets--;
        }
    }

    public int minSwapsCouples(int[] row) {
        int n = row.length;
        build(n / 2);
        for (int i = 0; i < n; i += 2) {
            // 两个位置只有不是情侣的会被合并
            union(row[i] / 2, row[i + 1] / 2);
        }
        return n / 2 - sets;
    }
}
