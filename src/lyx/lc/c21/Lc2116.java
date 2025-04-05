package lyx.lc.c21;

import lyx.lc.c6.Lc0678;

/**
 * 2116. 判断一个括号字符串是否有效
 *
 * @date 2025/03/23
 * @see Lc0678
 */
public class Lc2116 {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if ((n & 1) == 1) {
            return false;
        }
        // 可变的位置
        int[] mutableStack = new int[n];
        int mSize = 0;
        // 不可变左括号的位置
        int[] leftStack = new int[n];
        int lSize = 0;
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '1') {
                if (s.charAt(i) == '(') {
                    // 不可变左括号入栈
                    leftStack[lSize++] = i;
                } else {
                    // 不可变右括号必须匹配掉
                    if (lSize > 0) {
                        lSize--;
                    } else if (mSize == 0) {
                        return false;
                    } else {
                        mSize--;
                    }
                }
            } else {
                mutableStack[mSize++] = i;
            }
        }
        // 此时遍历完，一定没有不可变右括号了
        while (lSize > 0) {
            // 字符串遍历完还有不可变左括号
            if (mSize > 0 && mutableStack[mSize - 1] > leftStack[lSize - 1]) {
                // 如果有可变括号且位置在右边，可以匹配掉一个
                mSize--;
                lSize--;
            } else {
                return false;
            }
        }
        return true;
    }
}
