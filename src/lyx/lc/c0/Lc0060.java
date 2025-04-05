package lyx.lc.c0;

/**
 * 60. 排列序列
 *
 * @apiNote
 * 根据排列的规律可以得出，每一位的数字都是根据顺序轮转的，比如n的排列中，
 * 第一位数字会从1~n按(n-1)!个一组轮转，而在每一组中，下一位数字又从1~n
 * 中未使用过的数字按(n-2)!个一组轮转，这样依次下去。
 * <p>比如下面当n=4时：
 * <pre>
 *     1234    2134    3124    4123
 *     1243    2143    3142    4132
 *     1324    2314    3214    4213
 *     1342    2341    3241    4231
 *     1423    2413    3412    4312
 *     1432    2431    3421    4321
 * </pre>
 * 第一位数，每6(3的阶乘)个一组轮转，此时如果要找第k位数，就可以根据每组的
 * 数量确定他在哪一组，如k=10，那么他就在第2组。<p>
 * 确定好上一位在哪一组之后，在确认下一位数字之前，k需要减去这一组之前的数
 * 量，变成在这一组中的序号，同时这一组的数字是每2(2的阶乘)个一组轮换，然后
 * 就可以在这一组按照同样的逻辑去确定第二位了。这样依次下去，即可确认剩下所
 * 有位上的数字。
 */
public class Lc0060 {
    public String getPermutation(int n, int k) {
        // c=(n-1)!
        int c = 1;
        for (int i = 2; i < n; i++) {
            c *= i;
        }
        boolean[] visited = new boolean[n + 1];
        char[] ans = new char[n];
        int index = 0;
        while (index < n) {
            int no = (k + c - 1) / c; // 组号，向上取整
            // 在未出现过的数字中寻找
            for (int i = 1, j = 0; i <= n; i++) {
                if (!visited[i]) {
                    j++;
                }
                if (j == no) {
                    visited[i] = true;
                    ans[index++] = (char) (i + '0');
                    break;
                }
            }
            k -= c * (no - 1);
            if (index != n) {
                c /= n - index;
            }
        }
        return new String(ans);
    }
}
