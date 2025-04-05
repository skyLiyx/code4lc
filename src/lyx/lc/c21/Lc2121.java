package lyx.lc.c21;

import java.util.Arrays;

/**
 * 2121. 相同元素的间隔之和
 */
public class Lc2121 {
    // 出现次数
    private final long[] cnt = new long[100001];
    // 总长度
    private final long[] dis = new long[100001];

    public long[] getDistances(int[] arr) {
        Arrays.fill(cnt, 0);
        Arrays.fill(dis, 0);
        int n = arr.length;
        long[] ans = new long[n];
        for (int i = 0; i < n; i++) {
            int val = arr[i];
            if (cnt[val] > 0) {
                ans[i] += i * cnt[val] - dis[val];
            }
            dis[val] += i;
            cnt[val] += 1;
        }
        Arrays.fill(cnt, 0);
        Arrays.fill(dis, 0);
        for (int i = n - 1; i >= 0; i--) {
            int val = arr[i];
            if (cnt[val] > 0) {
                ans[i] += dis[val] - i * cnt[val];
            }
            dis[val] += i;
            cnt[val] += 1;
        }
        return ans;
    }
}
