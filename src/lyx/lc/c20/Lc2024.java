package lyx.lc.c20;

/**
 * 2024. 考试的最大困扰度
 */
public class Lc2024 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] c = answerKey.toCharArray();
        int ans = 0;
        int[] cnt = new int[2];
        for (int l = 0, r = 0; r < c.length; r++) {
            if (c[r] == 'F') {
                cnt[0]++;
            } else {
                cnt[1]++;
            }
            while (cnt[0] > k && cnt[1] > k) {
                if (c[l++] == 'F') {
                    cnt[0]--;
                } else {
                    cnt[1]--;
                }
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
