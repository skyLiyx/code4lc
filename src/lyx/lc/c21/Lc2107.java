package lyx.lc.c21;

/**
 * 2107. 分享 K 个糖果后独特口味的数量
 */
public class Lc2107 {
    public int shareCandies(int[] candies, int k) {
        int[] count = new int[100001];
        int type = 0;
        for (int candy : candies) {
            if (count[candy]++ == 0) {
                type++;
            }
        }
        if (k == 0) {
            return type;
        }
        for (int i = 0; i < k - 1; i++) {
            if (--count[candies[i]] == 0) {
                type--;
            }
        }
        int ans = type;
        for (int i = k - 1; i < candies.length; i++) {
            if (--count[candies[i]] == 0) {
                type--;
            }
            ans = Math.max(ans, type);
            if (count[candies[i - k + 1]]++ == 0) {
                type++;
            }
        }
        return ans;
    }
}
