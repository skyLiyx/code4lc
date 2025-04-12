package lyx.lc.c0;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 */
public class Lc0022 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        dfs(ans, new ArrayList<>(), n, 0, 0);
        return ans;
    }

    private void dfs(List<String> ans, List<String> path, int n, int i, int left) {
        if (i == n * 2) {
            ans.add(String.join("", path));
            return;
        }
        // i，当前位置
        // left，左括号的数量
        // 左括号数量小于一半，可以填左括号
        if (left < n) {
            path.add("(");
            dfs(ans, path, n, i + 1, left + 1);
            path.remove(path.size() - 1);
        }
        // i - left，右括号的数量
        // 右括号数量小于左括号的数量，可以填右括号
        if (i - left < left) {
            path.add(")");
            dfs(ans, path, n, i + 1, left);
            path.remove(path.size() - 1);
        }
    }
}
