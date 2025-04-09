package lyx.lc.c9;

/**
 * 904. 水果成篮
 */
public class Lc0904 {
    public int totalFruit(int[] fruits) {
        int[] count = new int[100000];
        int type = 0;
        int ans = 0;
        for (int l = 0, r = 0; r < fruits.length; r++) {
            if (count[fruits[r]]++ == 0) {
                type++;
            }
            while (type > 2) {
                if (--count[fruits[l++]] == 0) {
                    type--;
                }
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
