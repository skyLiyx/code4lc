package lyx.lc.c21;

/**
 * 2106. 摘水果
 */
public class Lc2106 {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        // 找到能到达的最左边，从这里开始滑动窗口
        int l = binarySearch(fruits, startPos - k);
        if (l == -1) {
            return 0;
        }
        int ans = 0;
        for (int r = l, sum = 0; r < n && fruits[r][0] <= startPos + k; r++) {
            sum += fruits[r][1];
            // 先往左走：(startPos - fruit[l][0]) + (fruit[r][0] - fruit[l][0])
            // 先往右走：(fruit[r][0] - startPos) + (fruit[r][0] - fruit[l][0])
            while (fruits[r][0] * 2 - startPos - fruits[l][0] > k && fruits[r][0] + startPos - fruits[l][0] * 2 > k) {
                sum -= fruits[l++][1];
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    public int binarySearch(int[][] fruits, int target) {
        int l = 0, r = fruits.length - 1, m;
        int ans = -1;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (fruits[m][0] >= target) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }
}
