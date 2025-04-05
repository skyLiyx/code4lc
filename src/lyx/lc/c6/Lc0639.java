package lyx.lc.c6;

import lyx.lc.c0.Lc0091;

/**
 * 639. 解码方法 II
 *
 * @see Lc0091
 */
public class Lc0639 {
    private static final long MOD = 1000000007;

    public int numDecodings(String s) {
        long next = 1;
        long nextNext = 0;
        char[] arr = s.toCharArray();
        long cur;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == '0') {
                cur = 0;
            } else {
                // 选择当前单个解码
                cur = next * (arr[i] == '*' ? 9 : 1);
                // 选择当前两个解码
                if (i + 1 < arr.length) {
                    if (arr[i] != '*') {
                        if (arr[i + 1] == '*') {
                            // 一个数字，一个 *
                            if (arr[i] == '1') {
                                cur += nextNext * 9;
                            } else if (arr[i] == '2') {
                                cur += nextNext * 6;
                            }
                        } else {
                            // 两个数字
                            if ((arr[i] - '0') * 10 + (arr[i + 1] - '0') <= 26) {
                                cur += nextNext;
                            }
                        }
                    } else {
                        if (arr[i + 1] == '*') {
                            // 两个 *
                            // 11~19共9个，21~26共6个，合计15个
                            cur += nextNext * 15;
                        } else {
                            // 一个 * 一个数字
                            if (arr[i + 1] <= '6') {
                                cur += nextNext * 2;
                            } else {
                                cur += nextNext;
                            }
                        }
                    }
                }
            }
            nextNext = next;
            next = cur % MOD;
        }
        return (int) next;
    }
}
