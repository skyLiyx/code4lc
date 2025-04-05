package lyx.lc.c1;

import java.util.HashMap;
import java.util.Map;

/**
 * 170. 两数之和 III - 数据结构设计
 */
public class Lc0170 {
    static class TwoSum {
        private final Map<Integer, Integer> numbers;
        private int min;
        private int max;

        public TwoSum() {
            numbers = new HashMap<>();
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
        }

        public void add(int number) {
            numbers.put(number, numbers.getOrDefault(number, 0) + 1);
            min = Math.min(min, number);
            max = Math.max(max, number);
        }

        public boolean find(int value) {
            if (value < min * 2 || value > max * 2) {
                return false;
            }
            for (Map.Entry<Integer, Integer> entry : numbers.entrySet()) {
                int number = entry.getKey();
                int count = entry.getValue();
                if (value == number * 2) {
                    if (count > 1) {
                        return true;
                    }
                } else {
                    if (numbers.containsKey(value - number)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
