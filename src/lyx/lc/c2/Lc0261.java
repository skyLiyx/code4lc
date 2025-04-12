package lyx.lc.c2;

/**
 * 261. 以图判树
 */
public class Lc0261 {
    public boolean validTree(int n, int[][] edges) {
        if (n != edges.length + 1) {
            return false;
        }
        build(n);
        for (int[] edge : edges) {
            if (!union(edge[0], edge[1])) {
                return false;
            }
        }
        return count == 1;
    }

    private static final int[] father = new int[2001];
    private static int count;

    private void build(int n) {
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
        count = n;
    }

    private int find(int i) {
        if (i != father[i]) {
            father[i] = find(father[i]);
        }
        return father[i];
    }

    private boolean union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa == fb) {
            return false;
        } else {
            father[fa] = father[fb];
            count--;
            return true;
        }
    }
}
