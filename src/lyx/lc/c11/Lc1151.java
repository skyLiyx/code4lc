package lyx.lc.c11;

/**
 * 1151. 最少交换次数来组合所有的 1
 */
public class Lc1151 {
    public int minSwaps(int[] data) {
        int len = 0; // 1的个数
        for (int d : data) {
            len += d;
        }
        if (len == 0) {
            return 0;
        }
        int ans = len;
        int cnt = 0;
        for (int i = 0; i < len - 1; i++) {
            if (data[i] == 0) {
                cnt++;
            }
        }
        for (int i = len - 1; i < data.length; i++) {
            if (data[i] == 0) {
                cnt++;
            }
            ans = Math.min(ans, cnt);
            if (data[i - len + 1] == 0) {
                cnt--;
            }
        }
        return ans;
    }
}
