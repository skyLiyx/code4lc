package lyx.lc.c7;

/**
 * 788. 旋转数字
 *
 * @apiNote 数位DP
 */
public class Lc0788 {
    public int rotatedDigits(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        int[] available = {0, 1, 2, 5, 6, 8, 9};
        return f(digits, available, 0, false, true, false);
    }

    /**
     *
     * @param digits         原数
     * @param available      可用数
     * @param curDigit       当前位
     * @param hasMirrorDigit 是否存在镜像数(2,5,6,9)
     * @param isLimit        当前位是否限制大小
     * @param isNum          是否数
     */
    private int f(char[] digits, int[] available, int curDigit, boolean hasMirrorDigit, boolean isLimit, boolean isNum) {
        if (curDigit == digits.length) {
            // 是数，且存在镜像数（不能和原数一样）
            return isNum && hasMirrorDigit ? 1 : 0;
        }
        int ans = 0;
        if (!isNum) {
            ans += f(digits, available, curDigit + 1, false, false, false);
        }
        int start = isNum ? 0 : 1;
        int up = isLimit ? digits[curDigit] - '0' : 9;
        for (int j = start; j < available.length && available[j] <= up; j++) {
            ans += f(digits, available, curDigit + 1, hasMirrorDigit || (j != 0 && j != 1 && j != 5), isLimit && up == available[j], true);
        }
        return ans;
    }

}
