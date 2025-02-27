package com.lynx.algorithm.string;

/**
 * Manacher，“马拉车”算法，专门用于计算最长回文子串的算法。
 *
 * @apiNote
 * <p>在从左往右遍历的过程中，维护一个最靠右的回文子串的中心点C和右边界R。
 * 往右遍历过程中，如果当前下标i在右边界R内，那么我们可以根据其在当前最靠
 * 右的回文子串的对称点i'来轻易计算出其回文半径。
 * <p>比较对称点i'的回文边界[l,r]和当前最靠右回文子串的边界[L,R]，具体
 * 分为三种场景：
 * <pre>
 *     1.l在L右边，即[l,r]在[L,R]范围内，依据回文的特性，当前位置i的
 *       回文半径就是i'的回文半径（不可能更长，否则i'的回文半径有错）。
 *     2.l在L左边，即[l,r]有部分在[L,R]范围外，依据回文的特性，当前
 *       位置i的回文半径就是i到R这一部分（不可能更长，否则中心点C的回文
 *       半径就有错）。
 *     3.l刚好和L重合，那么至少可以保证i到R与i左边同样距离的范围内是回
 *       文，此时只需从R开始往两边继续作比较。
 * </pre>
 * 当然，如果往右遍历过程中，当前下标i不在右边界R内，就只能暴力比较了。另
 * 外在整个过程中不要忘了随时维护更新最靠右的回文子串的中心点C和右边界R。
 * <p>更详细的内容请参考：
 * <a href="https://oi-wiki.org/string/manacher/">Manacher
 * - OI Wiki</a>
 */
public class Manacher {
    public static String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder("#");
        for (char c : s.toCharArray()) {
            sb.append(c).append("#");
        }
        char[] arr = sb.toString().toCharArray();
        int n = arr.length;
        int[] r = new int[n];
        int R = 0;  // 当前最右回文半径的右边界
        int C = 0; // 当前最右回文半径的中点
        for (int i = 1; i < n - 1; i++) {
            int mirror = (C << 1) - i; // i的对称点
            if (i < R) {
                r[i] = Math.min(R - i, r[mirror]);
            }
            // 尝试扩展回文半径
            while (i + (r[i] + 1) < n && i - (r[i] + 1) >= 0 && arr[i + (r[i] + 1)] == arr[i - (r[i] + 1)]) {
                r[i]++;
            }
            // 如果扩展后右边界超过当前right，更新
            if (i + r[i] > R) {
                C = i;
                R = i + r[i];
            }
        }
        int maxLen = 0;
        int index = 0;
        for (int i = 1; i < n - 1; i++) {
            if ((i & 1) == 1 && r[i] > maxLen) {
                maxLen = r[i];
                index = i;
            }
        }
        int start = (index - maxLen) >> 1;
        return s.substring(start, start + maxLen);
    }
}
