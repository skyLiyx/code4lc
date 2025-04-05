package lyx.lc.c20;

import java.util.*;

/**
 * 2080.区间内查询数字的频率
 *
 * @date 2025/02/18
 */
public class Lc2080 {
    public static class RangeFreqQuery {

        Map<Integer, List<Integer>> map;

        public RangeFreqQuery(int[] arr) {
            map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                map.putIfAbsent(arr[i], new ArrayList<>());
                map.get(arr[i]).add(i); // 从小到大的
            }
        }

        public int query(int left, int right, int value) {
            List<Integer> list = map.getOrDefault(value, new ArrayList<>());
            int l = leftIndexOf(list, left);
            int r = rightIndexOf(list, right);
            return r - l;
        }

        private int leftIndexOf(List<Integer> list, int value) {
            int l = 0;
            int r = list.size() - 1;
            while (l <= r) {
                int m = l + ((r - l) >> 1);
                if (list.get(m) < value) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            return l;
        }

        private int rightIndexOf(List<Integer> list, int value) {
            int l = 0;
            int r = list.size() - 1;
            while (l <= r) {
                int m = l + ((r - l) >> 1);
                if (list.get(m) <= value) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            return l;
        }
    }
}
