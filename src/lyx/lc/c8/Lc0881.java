package lyx.lc.c8;

import java.util.Arrays;

/**
 * 881. 救生艇
 */
public class Lc0881 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int ans = 0;
        int l = 0, r = people.length - 1;
        while (l <= r) {
            if (people[l] + people[r] <= limit) {
                // 如果左右两边不超载，可以同时载一个左边的
                l++;
            }
            r--;
            ans++;
        }
        return ans;
    }
}
