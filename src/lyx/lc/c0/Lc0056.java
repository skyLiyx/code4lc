package lyx.lc.c0;

import java.util.ArrayList;
import java.util.List;

/**
 * 56. 合并区间
 *
 * @apiNote 差分
 */
public class Lc0056 {
    public int[][] merge(int[][] intervals) {
        int n = 0;
        for (int[] interval : intervals) {
            n = Math.max(n, interval[1]);
        }
        int[] diff = new int[(n << 1) + 2];
        for (int[] interval : intervals) {
            diff[interval[0] << 1]++;
            diff[(interval[1] << 1) + 1]--;
        }
        for (int i = 1; i < diff.length - 1; i++) {
            diff[i] += diff[i - 1];
        }
        List<int[]> list = new ArrayList<>();
        for (int l = 0, r; l < diff.length; l++) {
            if (diff[l] != 0) {
                r = l;
                while (r + 1 < diff.length && diff[r + 1] != 0) {
                    r++;
                }
                list.add(new int[]{l >> 1, r >> 1});
                l = r;
            }
        }
        int[][] ans = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
