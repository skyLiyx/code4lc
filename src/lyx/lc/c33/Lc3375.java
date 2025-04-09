package lyx.lc.c33;

import java.util.HashSet;
import java.util.Set;

/**
 * 3375. 使数组的值全部为 K 的最少操作次数
 *
 * @date 2025/04/09
 */
public class Lc3375 {
    public int minOperations(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int flag = 0;
        for (int num : nums) {
            if (num < k) return -1;
            if (num == k) flag = 1;
            set.add(num);
        }
        return set.size() - flag;
    }
}
