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
        List<List<String>> ans = new ArrayList<>();
        char[] arr = s.toCharArray();
        dfs(ans, new ArrayList<>(), arr, 0, 0);
        return ans;
    }

    private void dfs(List<List<String>> ans, List<String> list, char[] arr, int l, int r) {
        if (l == arr.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (r == arr.length) {
            return;
        }
        // 不在这里分割，继续往右扩
        dfs(ans, list, arr, l, r + 1);
        // 在这里分割，是回文才能在这里分割
        if (check(arr, l, r)) {
            list.add(new String(arr, l, r - l + 1)); // 分割的就是l~r范围的子串
            dfs(ans, list, arr, r + 1, r + 1); // 然后新的子串从r+1开始
            list.remove(list.size() - 1);
        }
    }

    private boolean check(char[] arr, int l, int r) {
        while (l <= r) {
            if (arr[l++] != arr[r--]) {
                return false;
            }
        }
        return true;
    }
}
