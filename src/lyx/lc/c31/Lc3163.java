package lyx.lc.c31;

/**
 * 3163. 压缩字符串 III
 */
public class Lc3163 {
    public String compressedString(String word) {
        char[] arr = word.toCharArray();
        int n = arr.length;
        char[] ans = new char[n << 1];
        int p = 0;
        for (int i = 0, j; i < n; i = j) {
            j = i + 1;
            while (j < Math.min(i + 9, n) && arr[i] == arr[j]) {
                j++;
            }
            ans[p++] = (char)(j - i + '0');
            ans[p++] = arr[i];
        }
        return new String(ans, 0, p);
    }
}
