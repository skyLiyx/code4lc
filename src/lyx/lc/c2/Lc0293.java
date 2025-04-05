package lyx.lc.c2;

import java.util.ArrayList;
import java.util.List;

/**
 * 293. 翻转游戏
 */
public class Lc0293 {
    public List<String> generatePossibleNextMoves(String currentState) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder(currentState);
        for (int i = 0; i < currentState.length() - 1; i++) {
            if (currentState.charAt(i) == '+' && currentState.charAt(i + 1) == '+') {
                ans.add(sb.replace(i, i + 2, "--").toString());
                sb.replace(i, i + 2, "++");
            }
        }
        return ans;
    }
}
