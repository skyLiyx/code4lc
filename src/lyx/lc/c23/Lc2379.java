package lyx.lc.c23;

/**
 * 2379. 得到 K 个黑块的最少涂色次数
 */
public class Lc2379 {
    public int minimumRecolors(String blocks, int k) {
        int ans = k;
        int count = 0;
        char[] arr = blocks.toCharArray();
        for (int i = 0; i < k - 1; i++) {
            if (arr[i] == 'W') {
                count++;
            }
        }
        for (int i = k - 1; i < arr.length; i++) {
            if (arr[i] == 'W') {
                count++;
            }
            ans = Math.min(ans, count);
            if (arr[i - k + 1] == 'W') {
                count--;
            }
        }
        return ans;
    }
}
