package lyx.lc.c16;

import java.util.ArrayList;
import java.util.List;

/**
 * 1656.设计有序流
 *
 * @date 2025/02/24
 */
public class Lc1656 {

    public static class OrderedStream {
        private final String[] values;

        private int ptr;

        public OrderedStream(int n) {
            this.values = new String[n];
            this.ptr = 1;
        }

        public List<String> insert(int idKey, String value) {
            this.values[idKey - 1] = value;
            List<String> res = new ArrayList<>();
            int curIndex = this.ptr - 1;
            while (curIndex < values.length && this.values[curIndex] != null) {
                res.add(this.values[curIndex]);
                this.ptr = curIndex + 2;
                curIndex++;
            }
            return res;
        }
    }

}
