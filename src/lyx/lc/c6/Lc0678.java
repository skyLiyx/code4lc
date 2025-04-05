package lyx.lc.c6;

/**
 * 678. 有效的括号字符串
 */
public class Lc0678 {
    public boolean checkValidString(String s) {
        int n = s.length();
        int[] leftStack = new int[n];
        int lSize = 0;
        int[] asteriskStack = new int[n];
        int aSize = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                leftStack[lSize++] = i;
            } else if (s.charAt(i) == '*') {
                asteriskStack[aSize++] = i;
            } else {
                if (lSize > 0) {
                    lSize--;
                } else if (aSize > 0) {
                    aSize--;
                } else {
                    return false;
                }
            }
        }
        while (lSize > 0) {
            if (aSize > 0 && asteriskStack[aSize - 1] > leftStack[lSize - 1]) {
                lSize--;
                aSize--;
            } else {
                return false;
            }
        }
        return true;
    }
}
