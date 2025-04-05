package lyx.lc.c34;

/**
 * 3407. 子字符串匹配模式
 */
public class Lc3407 {
    public boolean hasMatch(String s, String p) {
        if (p.equals("*")) {
            return true;
        }
        char[] arr = p.toCharArray();
        int index = 0;
        while (index < arr.length && arr[index] != '*') {
            index++;
        }
        int left = s.indexOf(p.substring(0, index));
        int right = s.lastIndexOf(p.substring(index + 1));
        return left != -1 && right != -1 && right > left + index - 1;
    }
}
