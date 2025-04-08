package lyx.lc.c11;

/**
 * 1100. 长度为 K 的无重复字符子串
 */
public class Lc1100 {
    public int numKLenSubstrNoRepeats(String s, int k) {
        int[] count = new int[26];
        char[] arr = s.toCharArray();
        int ans = 0;
        int cnt = 0;
        for (int i = 0; i < k - 1; i++) {
            if (count[arr[i] - 'a']++ == 0) {
                cnt++;
            }
        }
        for (int i = k - 1; i < arr.length; i++) {
            if (count[arr[i] - 'a']++ == 0) {
                cnt++;
            }
            if (cnt == k) {
                ans++;
            }
            if (--count[arr[i - k + 1] - 'a'] == 0) {
                cnt--;
            }
        }
        return ans;
    }
}
