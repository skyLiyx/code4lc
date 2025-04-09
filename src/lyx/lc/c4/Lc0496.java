package lyx.lc.c4;

import java.util.Arrays;

/**
 * 496. 下一个更大元素 I
 */
public class Lc0496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] ans = new int[m];
        Arrays.fill(ans, -1);
        int[] stack = new int[n];
        int size = 0;
        for (int i = 0; i < n; i++) {
            while (size > 0 && nums2[i] > nums2[stack[size - 1]]) {
                int cur = stack[--size];
                for (int j = 0; j < m; j++) {
                    if (nums2[cur] == nums1[j]) {
                        ans[j] = nums2[i];
                        break;
                    }
                }
            }
            stack[size++] = i;
        }
        return ans;
    }
}
