package lyx.lc.c4;

/**
 * 402. 移掉 K 位数字
 *
 * @apiNote 单调栈
 */
public class Lc0402 {
    private final char[] stack = new char[100000];

    public String removeKdigits(String num, int k) {
        if (k == num.length()) {
            return "0";
        }
        int size = 0;
        for (char c : num.toCharArray()) {
            while (size > 0 && stack[size - 1] > c && k > 0) {
                size--;
                k--;
            }
            if (size != 0 || c != '0') {
                stack[size++] = c;
            }
        }
        return size - k <= 0 ? "0" : String.valueOf(stack, 0, size - k);
    }
}
