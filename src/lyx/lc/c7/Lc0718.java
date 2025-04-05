package lyx.lc.c7;

/**
 * 718. 最长重复子数组
 */
public class Lc0718 {
    public int findLength(int[] nums1, int[] nums2) {
        int ans = compare(nums1, nums2);
        ans = Math.max(ans, compare(nums2, nums1));
        return ans;
    }

    private int compare(int[] nums1, int[] nums2) {
        // 枚举对齐点，nums1从对齐点开始，nums2从0开始，找出相同的子数组
        int ans = 0;
        int n = nums1.length;
        int m = nums2.length;
        for (int start = 0; start < n && n - start > ans; start++) {
            for (int p1 = start, p2 = 0; p1 < n && p2 < m; p1++,p2++) {
                if(nums1[p1] == nums2[p2]) {
                    int s = 1;
                    while (p1 + s < n && p2 + s < m && nums1[p1 + s] == nums2[p2 + s]) {
                        s++;
                    }
                    ans = Math.max(ans, s);
                    p1 += s - 1;
                    p2 += s - 1;
                }
            }
        }
        return ans;
    }
}
