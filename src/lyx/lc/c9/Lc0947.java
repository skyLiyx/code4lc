package lyx.lc.c9;

import java.util.HashMap;
import java.util.Map;

/**
 * 947. 移除最多的同行或同列石头
 *
 * @apiNote 并查集
 */
public class Lc0947 {
    private static final int MAXN = 1001;
    private final int[] father = new int[MAXN];
    private int sets;
    private final Map<Integer, Integer> firstXMap = new HashMap<>();
    private final Map<Integer, Integer> firstYMap = new HashMap<>();

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

    public int removeStones(int[][] stones) {
        firstXMap.clear();
        firstYMap.clear();
        int n = stones.length;
        build(n);
        for (int i = 0; i < n; i++) {
            int x = stones[i][0];
            int y = stones[i][1];
            // 分别判断当前x方向和y方向是否已经存在石头
            // 如果存在就合并，否则就记录进map
            if (firstXMap.containsKey(x)) {
                union(i, firstXMap.get(x));
            } else {
                firstXMap.put(x, i);
            }
            if (firstYMap.containsKey(y)) {
                union(i, firstYMap.get(y));
            } else {
                firstYMap.put(y, i);
            }
        }
        return n - sets;
    }
}
