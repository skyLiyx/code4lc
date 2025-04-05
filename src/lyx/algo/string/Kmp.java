package lyx.algo.string;

/**
 * KMP（Knuth-Morris-Pratt）算法，用于匹配子字符串。
 * <p>核心思想是通过预处理模式串，构建一个部分匹配表（也称为“失败函数”
 * 或“next数组”），从而在匹配失败时跳过不必要的比较。
 *
 * @apiNote
 * 首先对待匹配的字符串做预处理，构建一个 next 数组，用于存放每一个字
 * 符之前的子串的最长相同前缀和后缀的长度。例如：
 * <pre>
 *     ABDABCABAB
 * </pre>
 * C之前的最长相同前缀和后缀就是AB，所以<code>next[5]=2</code>。
 *
 * <p>而在从左往右匹配过程中，每次遇到不同字符时，将匹配串的指针移动到
 * next 数组对应的位置。例如，当匹配过程中两个指针处于如下的位置：
 * <pre>
 *             v
 *     a: ABDABDABACDABABCABAB
 *     b: ABDABCABAB
 *             ^
 * </pre>
 * 此时将pattern的指针移动到下标2的位置，如下：
 * <pre>
 *             v
 *     a: ABDABDABACDABABCABAB
 *     b:    ABDABCABAB
 *             ^
 * </pre>
 * 换种说法，下方在C之前的子串和上方在D之前相同长度的子串可以确定匹配，
 * 所以由next数组确定的C的前缀可以和D前面相同长度的子串直接匹配。由此
 * 可以实现常数级的损耗降低。
 * <p>更详细的内容请参考：
 * <a href="https://oi-wiki.org/string/kmp/">前缀函数与KMP
 * 算法 - OI Wiki</a>
 */
public class Kmp {
    public static int kmpSearch(String text, String pattern) {
        if (text == null || pattern == null || pattern.isEmpty() || pattern.length() > text.length()) {
            return -1;
        }
        int[] next = buildNextArray(pattern);
        int p1 = 0, p2 = 0;
        while (p1 < text.length() && p2 < pattern.length()) {
            if (text.charAt(p1) == pattern.charAt(p2)) {
                p1++;
                p2++;
            } else if (p2 > 0) {
                p2 = next[p2];
            } else {
                p1++;
            }
        }
        if (p2 >= pattern.length()) {
            return p1 - p2;
        }
        return -1;
    }

    private static int[] buildNextArray(String m) {
        int[] next = new int[m.length()];
        next[0] = -1;
        for (int i = 2; i < next.length; i++) {
            // i位置的结果可以由i-1位置确定，以i-1位置的字符为基准，将next[i-1]
            // 作为待比较位置j，比较两个位置的字符：
            // - 如果相同，那么next[i]可以直接+1（不可能更长，否则next[i-1]的
            // 值有错）；
            // - 如果不同，那么待比较位置j从当前位置继续往前跳到next[j]，直到两个
            // 字符相同或者j无法再跳为止（同样的不可能更长，否则next[j]的值有错）。
            int j = i - 1;
            while (j > 0 && m.charAt(j) != m.charAt(next[j])) {
                j = next[j];
            }
            next[i] = next[j] + 1;
        }
        return next;
    }
}
