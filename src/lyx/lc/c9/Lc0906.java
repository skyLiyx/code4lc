package lyx.lc.c9;

/**
 * 906.超级回文数
 */
public class Lc0906 {
    public int superpalindromesInRange(String left, String right) {
        int ans = 0;
        long l = Long.parseLong(left);
        long r = Long.parseLong(right);
        long limit = (long)Math.sqrt((double)r);
        long seed = 1;
        long num;
        do {
            num = evenPalindrome(seed);
            if (check(num * num, l, r)) {
                ans++;
            }
            num = oddPalindrome(seed);
            if (check(num * num, l, r)) {
                ans++;
            }
            seed++;
        } while (num < limit);
        return ans;
    }

    private long evenPalindrome(long seed) {
        long ans = seed;
        while (seed != 0) {
            ans = ans * 10 + seed % 10;
            seed /= 10;
        }
        return ans;
    }

    private long oddPalindrome(long seed) {
        long ans = seed;
        seed /= 10;
        while (seed != 0) {
            ans = ans * 10 + seed % 10;
            seed /= 10;
        }
        return ans;
    }

    private boolean check(long n, long l, long r) {
        if (n < l || n > r) {
            return false;
        }
        long offset = 1;
        while (n / offset >= 10) {
            offset *= 10;
        }
        while (n != 0) {
            if (n / offset != n % 10) {
                return false;
            }
            n = (n % offset) / 10;
            offset /= 100;
        }
        return true;
    }
}