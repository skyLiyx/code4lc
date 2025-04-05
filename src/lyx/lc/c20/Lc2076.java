package lyx.lc.c20;

/**
 * 2076. 处理含限制条件的好友请求
 *
 * @apiNote 并查集
 */
public class Lc2076 {
    private static final int MAXN = 1001;
    private final int[] father = new int[MAXN];

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

    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        build(n);
        int m = requests.length;
        boolean[] ans = new boolean[m];
        for (int i = 0; i < m; i++) {
            int x = requests[i][0];
            int y = requests[i][1];
            int fx = find(x);
            int fy = find(y);
            ans[i] = true;
            if (fx != fy) {
                for (int[] restriction : restrictions) {
                    int fu = find(restriction[0]);
                    int fv = find(restriction[1]);
                    if ((fx == fu && fy == fv) || (fx == fv && fy == fu)) {
                        ans[i] = false;
                        break;
                    }
                }
                if (ans[i]) {
                    union(fx, fy);
                }
            }
        }
        return ans;
    }
}
