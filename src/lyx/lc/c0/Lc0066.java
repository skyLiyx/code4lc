package lyx.lc.c0;

/**
 * 66. 加一
 */
public class Lc0066 {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        digits[n - 1]++;
        // 从最后一位开始检查是否进位
        int p = n - 1;
        while (p > 0 && digits[p] == 10) {
            digits[p--] = 0;
            digits[p]++;
        }
        if (p != 0 || digits[p] != 10) {
            return digits;
        }
        // 进位到了第0位还是10
        int[] ans = new int[n + 1];
        ans[0] = 1;
        ans[1] = 0;
        for (int i = 1; i < n; i++) {
            ans[i + 1] = digits[i];
        }
        return ans;
    }
}
