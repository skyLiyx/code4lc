package lyx.lc.c8;

/**
 * 839. 相似字符串组
 *
 * @apiNote 并查集
 */
public class Lc0839 {
    private final int[] father = new int[301];
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

    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        build(n);
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                // 检查每对字符串组是否相似
                int diff = 0;
                for (int k = 0; k < m && diff < 3; k++) {
                    if (strs[i].charAt(k) != strs[j].charAt(k)) {
                        diff++;
                    }
                }
                if (diff == 0 || diff == 2) {
                    union(i, j);
                }
            }
        }
        return sets;
    }
}
