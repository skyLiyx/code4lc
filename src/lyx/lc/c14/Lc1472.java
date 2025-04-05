package lyx.lc.c14;

import java.util.ArrayList;
import java.util.List;

/**
 * 1472.设计浏览器历史记录
 *
 * @date 2025/02/26
 */
public class Lc1472 {

    public static class BrowserHistory {
        private final List<String> list;
        private int cur;

        public BrowserHistory(String homepage) {
            list = new ArrayList<>();
            list.add(homepage);
            cur = 0;
        }

        public void visit(String url) {
            int i = list.size() - 1;
            while (i > cur) {
                list.remove(i--);
            }
            list.add(url);
            cur++;
        }

        public String back(int steps) {
            cur -= steps;
            if (cur < 0) {
                cur = 0;
            }
            return list.get(cur);
        }

        public String forward(int steps) {
            cur += steps;
            if (cur >= list.size()) {
                cur = list.size() - 1;
            }
            return list.get(cur);
        }
    }

}
