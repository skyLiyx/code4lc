package lyx.lc.c0;

import java.util.ArrayList;
import java.util.List;

/**
 * 57. 插入区间
 *
 * @apiNote 差分
 */
public class Lc0057 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = 0;
        for (int[] interval : intervals) {
            n = Math.max(n, interval[1]);
        }
        n = Math.max(n, newInterval[1]);
        n <<= 1;
        int[] diff = new int[n + 2];
        for (int[] interval : intervals) {
            diff[interval[0] << 1]++;
            diff[(interval[1] << 1) + 1]--;
        }
        diff[newInterval[0] << 1]++;
        diff[(newInterval[1] << 1) + 1]--;
        for (int i = 1; i < n + 2; i++) {
            diff[i] += diff[i - 1];
        }
        List<int[]> list = new ArrayList<>();
        for (int l = 0, r; l <= n; l++) {
            if (diff[l] != 0) {
                r = l;
                while (r + 1 <= n && diff[r + 1] != 0) {
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
