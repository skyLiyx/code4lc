package lyx.lc.c2;

/**
 * 204. 计数质数
 */
public class Lc0204 {
    public int countPrimes(int n) {
        boolean[] visited = new boolean[n + 1];
        // 排除所有偶数
        int[] prime = new int[n / 2 + 1];
        int cnt = 0;
        for (int i = 2; i <= n; i++) {
            if (!visited[i]) {
                prime[cnt++] = i;
            }
            for (int j = 0; j < cnt; j++) {
                if (i * prime[j] > n) {
                    break;
                }
                visited[i * prime[j]] = true;
                if (i % prime[j] == 0) {
                    break;
                }
            }
        }
        return cnt;
    }
}
