package com.lynx.lc.c17;

import java.util.HashMap;
import java.util.Map;

/**
 * 1742.盒子中小球的最大数量。
 *
 * @date 2025/02/13
 */
public class Lc1742 {
    public int countBalls(int lowLimit, int highLimit) {
        int res = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = lowLimit; i <= highLimit; i++) {
            int sum = 0, x = i;
            while (x != 0) {
                sum += x % 10;
                x /= 10;
            }
            Integer count = countMap.compute(sum, (k, v) -> v == null ? 1 : v + 1);
            res = Math.max(res, count);
        }
        return res;
    }
}
