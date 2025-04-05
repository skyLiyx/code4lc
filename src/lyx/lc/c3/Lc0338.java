package lyx.lc.c3;

/**
 * 338. 比特位计数
 */
public class Lc0338 {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        ans[0] = 0;
        for (int i = 1, t, rightOne; i <= n; i++) {
            if ((i & 1) == 0) {
                ans[i] = ans[i >> 1];
            } else {
                t = i;
                while (t != 0) {
                    ans[i]++;
                    rightOne = t & (~t + 1);
                    t ^= rightOne;
                }
            }
        }
        return ans;
    }
}
