package lyx.lc.c10;

/**
 * 1052. 爱生气的书店老板
 */
public class Lc1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int ans = 0;
        int sum = 0;
        int n = customers.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + (grumpy[i - 1] == 1 ? 0 : customers[i - 1]);
            suffix[n - i - 1] = suffix[n - i] + (grumpy[n - i] == 1 ? 0 : customers[n - i]);
        }
        for (int i = 0; i < minutes - 1; i++) {
            sum += customers[i];
        }
        for (int i = minutes - 1; i < n; i++) {
            sum += customers[i];
            ans = Math.max(ans, sum + prefix[i - minutes + 1] + suffix[i]);
            sum -= customers[i - minutes + 1];
        }
        return ans;
    }
}
