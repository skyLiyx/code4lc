package lyx.lcp;

/**
 * LCP 08. 剧情触发时间
 */
public class LCP08 {
    public int[] getTriggerTime(int[][] increase, int[][] requirements) {
        int n = increase.length, m = requirements.length;
        for (int i = 1; i < n; i++) {
            increase[i][0] += increase[i - 1][0];
            increase[i][1] += increase[i - 1][1];
            increase[i][2] += increase[i - 1][2];
        }
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ans[i] = binarySearch(increase, requirements[i]);
        }
        return ans;
    }

    public int binarySearch(int[][] increase, int[] requirement) {
        if (requirement[0] == 0 && requirement[1] == 0 && requirement[2] == 0) {
            return 0;
        }
        int l = 0, r = increase.length - 1, m;
        int ans = -1;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (increase[m][0] >= requirement[0] && increase[m][1] >= requirement[1] && increase[m][2] >= requirement[2]) {
                ans = m + 1;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }
}
