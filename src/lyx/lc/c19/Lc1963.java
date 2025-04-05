package lyx.lc.c19;

/**
 * 1963. 使字符串平衡的最小交换次数
 *
 * @date 2025/03/17
 */
public class Lc1963 {
    public int minSwaps(String s) {
        int ans = 0;
        char[] arr = s.toCharArray();
        for (int i = 0, open = 0, close = 0; i < arr.length; i++) {
            if (arr[i] == '[') {
                open++;
            } else {
                close++;
            }
            if (close > open) {
                // 当右括号多了时替换
                ans++;
                open++;
                close--;
            }
        }
        return ans;
    }
}
