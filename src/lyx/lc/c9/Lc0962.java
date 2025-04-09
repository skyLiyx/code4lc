package lyx.lc.c9;

/**
 * 962. 最大宽度坡
 *
 * @apiNote 单调栈。首先将能够组成坡{@code (i,j)}中的 i 按单调递减顺序放入栈中。
 * <pre>
 *     为了组成坡必须让 i 尽可能的小，实际上栈中保存的是组成坡的可能性。
 * </pre>
 * 然后从右往左遍历，如果遇到满足条件的 j 和栈顶元素 i 组成坡，那么他当前一定是宽度
 * 最大的。
 * <pre>
 *     反证：假设此时不是宽度最大的，那么只能继续往左遍历，如果又遇到，此时宽度一定
 *     减小，与假设矛盾。
 * </pre>
 * 之后，栈顶弹出，i 的可能性左移( i 增大，宽度也增加)，继续判断。
 */
public class Lc0962 {
    private final int[] stack = new int[50000];

    public int maxWidthRamp(int[] nums) {
        int ans = 0, size = 0, n = nums.length;
        stack[size++] = 0;
        // 将组成坡的 i 的可能性放入栈
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[stack[size - 1]]) {
                stack[size++] = i;
            }
        }
        // 从右往左遍历
        for (int i = n - 1; i > 0; i--) {

            while (size > 0 && nums[i] >= nums[stack[size - 1]]) {
                ans = Math.max(ans, i - stack[--size]);
            }
        }
        return ans;
    }
}
