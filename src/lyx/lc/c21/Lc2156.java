package lyx.lc.c21;

/**
 * 2156. 查找给定哈希值的子串
 */
public class Lc2156 {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        long hash = 0, p = 1;
        // 秦九韶算法
        // S = 最高项系数，循环执行
        // S = S * x + 低次项系数
        for (int i = n - 1; i >= n - k; i--) {
            hash = (hash * power + (arr[i] & 31)) % modulo;
            p = p * power % modulo;
        }
        int start = hash == hashValue ? n - k : 0;
        for (int i = n - k - 1; i >= 0; i--) {
            hash = ((hash * power + (arr[i] & 31)) - (p * (arr[i + k] & 31) % modulo) + modulo) % modulo;
            if (hash == hashValue) {
                start = i;
            }
        }
        return s.substring(start, start + k);
    }
}
