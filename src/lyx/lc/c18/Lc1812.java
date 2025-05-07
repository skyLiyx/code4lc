package lyx.lc.c18;

/**
 * 1812. 判断国际象棋棋盘中一个格子的颜色
 */
public class Lc1812 {
    public boolean squareIsWhite(String coordinates) {
        int x = coordinates.charAt(0) - 'a';
        int y = coordinates.charAt(1) - '1';
        return (x & 1) != (y & 1);
    }
}
