package com.lynx.lc.c1;

/**
 * 157. 用 Read4 读取 N 个字符
 */
public class Lc0157 {

    /**
     * The read4 API is defined in the parent class Reader4.
     *     int read4(char[] buf4);
     */
    public static class Solution extends Reader4 {
        /**
         * @param buf Destination buffer
         * @param n   Number of characters to read
         * @return    The number of actual characters read
         */
        public int read(char[] buf, int n) {
            char[] buf4 = new char[4];
            int ans = 0;
            for (int i = 0, p; i < n; i += 4) {
                p = read4(buf4);
                ans += p;
                if (p == 0) {
                    break;
                }
                System.arraycopy(buf4, 0, buf, i, Math.min(n - i, p));
            }
            return Math.min(ans, n);
        }
    }

    /* ****************** for compile correctly ********************/
    static class Reader4 {
        native int read4(char[] buf4);
    }
    /* ****************** for compile correctly ********************/

}
