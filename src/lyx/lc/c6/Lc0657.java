package lyx.lc.c6;

/**
 * 657. 机器人能否返回原点
 */
public class Lc0657 {
    public boolean judgeCircle(String moves) {
        char[] arr = moves.toCharArray();
        int a = 0, b = 0;
        for (char c : arr) {
            if (c == 'R') a++;
            if (c == 'L') a--;
            if (c == 'U') b++;
            if (c == 'D') b--;
        }
        return a == 0 && b == 0;
    }
}
