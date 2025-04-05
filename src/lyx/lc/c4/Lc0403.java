package lyx.lc.c4;

import java.util.HashMap;
import java.util.Map;

/**
 * 403. 青蛙过河
 */
public class Lc0403 {
    public boolean canCross(int[] stones) {
        if (stones[1] > 1) {
            return false;
        }
        Map<Integer, Map<Integer, Boolean>> map = new HashMap<>();
        return f(stones, 1, 1, map);
    }

    private boolean f(int[] stones, int i, int k, Map<Integer, Map<Integer, Boolean>> map) {
        if(i == stones.length - 1) {
            return true;
        }
        if (map.containsKey(i) && map.get(i).containsKey(k)) {
            return map.get(i).get(k);
        }
        for (int next = i + 1, step; next < stones.length && (step = stones[next] - stones[i]) <= k + 1; next++) {
            if (step >= k - 1 && f(stones, next, step, map)) {
                if (!map.containsKey(i)) {
                    map.put(i, new HashMap<>());
                }
                map.get(i).put(k, true);
                return true;
            }
        }
        if (!map.containsKey(i)) {
            map.put(i, new HashMap<>());
        }
        map.get(i).put(k, false);
        return false;
    }
}
