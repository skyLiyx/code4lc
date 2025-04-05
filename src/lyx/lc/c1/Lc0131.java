package lyx.lc.c1;

import java.util.ArrayList;
import java.util.List;

/**
 * 131.分割回文串
 *
 * @date 2025/03/01
 */
public class Lc0131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrace(res, new ArrayList<>(), s, 0);
        return res;
    }

    private void backtrace(List<List<String>> res, List<String> list, String s, int begin) {
        if (begin >= s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        // 从长度1开始查找
        for (int i = 1; i <= s.length() - begin; i++) {
            if (!isPalindrome(s, begin, begin + i)) {
                continue;
            }
            list.add(s.substring(begin, begin + i));
            // 确定一个回文后，按照此方法继续查找剩余字符
            backtrace(res, list, s, begin + i);
            list.remove(list.size() - 1);
        }
    }

    private boolean isPalindrome(String s, int begin, int end) {
        while (begin < end) {
            if (s.charAt(begin++) != s.charAt(--end)) {
                return false;
            }
        }
        return true;
    }
}
