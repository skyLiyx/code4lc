package lyx.lc.c28;

/**
 * 2843. 统计对称整数的数目
 *
 * @date 2025/04/11
 */
public class Lc2843 {
    public int countSymmetricIntegers(int low, int high) {
        int ans = 0;
        for (int i = low; i <= high; i++) {
            if (i < 100 && i % 11 == 0) {
                ans++;
            } else if (i > 1000) {
                char[] c = String.valueOf(i).toCharArray();
                if (c[0] + c[1] == c[2] + c[3]) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
