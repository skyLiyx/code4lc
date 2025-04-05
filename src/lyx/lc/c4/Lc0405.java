package lyx.lc.c4;

/**
 * 405. 数字转换为十六进制数
 */
public class Lc0405 {
    private static final int MASK = 0xf;

    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.insert(0, toHexCharacter(MASK & num));
            num >>>= 4;
        }
        return sb.toString();
    }

    private char toHexCharacter(int num) {
        if (num < 10) {
            return (char) (num + '0');
        }
        return (char) (num - 10 + 'a');
    }
}
