package lyx.lc.c0;

/**
 * 3. 无重复字符的最长子串
 *
 * @apiNote 滑动窗口
 */
public class Lc0003 {
    public int lengthOfLongestSubstring(String s) {
        int[] cnt = new int[128];
        char[] arr = s.toCharArray();
        int ans = 0;
        for (int l = 0, r = 0; r < arr.length; r++) {
            cnt[arr[r]]++;
            while (cnt[arr[r]] > 1) {
                cnt[arr[l++]]--;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
