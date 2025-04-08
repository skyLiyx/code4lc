package lyx.lc.c18;

/**
 * 1888. 使二进制字符串字符交替的最少反转次数
 */
public class Lc1888 {
    public int minFlips(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        if (n == 1) {
            return 0;
        }
        int ans = n;
        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            if (((arr[i] - '0') & 1) != (i & 1)) {
                cnt++;
            }
        }
        for (int i = n - 1; i < (n << 1) - 1; i++) {
            if (((arr[i % n] - '0') & 1) != (i & 1)) {
                cnt++;
            }
            ans = Math.min(ans, Math.min(cnt, n - cnt));
            if (((arr[i - n + 1] - '0') & 1) != (i & 1)) {
                cnt--;
            }
        }
        return ans;
    }
}
