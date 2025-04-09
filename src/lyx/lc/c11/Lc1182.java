package lyx.lc.c11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1182. 与目标颜色间的最短距离
 */
public class Lc1182 {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        List<Integer> ans = new ArrayList<>();
        ArrayList<Integer>[] list =new ArrayList[4];
        Arrays.setAll(list, ArrayList::new);
        for (int i = 0; i < colors.length; i++) {
            list[colors[i]].add(i);
        }
        for (int[] query : queries) {
            ans.add(binarySearch(list, query[0], query[1]));
        }
        return ans;
    }

    private int binarySearch(ArrayList<Integer>[] colors, int i, int c) {
        if (colors[c].isEmpty()) {
            return -1;
        }
        int l = 0, r = colors[c].size() - 1, m;
        int ans = -1; // 大于等于i最左边的位置
        while (l <= r) {
            m = l + (r - l) / 2;
            if (colors[c].get(m) >= i) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        if (ans > 0 && i - colors[c].get(ans - 1) < colors[c].get(ans) - i) {
            ans = ans - 1;
        }
        return ans == -1 ? Math.abs(i - colors[c].get(colors[c].size() - 1)) : Math.abs(i - colors[c].get(ans));
    }
}
