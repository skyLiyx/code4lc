package lyx.lc.c0;

/**
 * 4. 寻找两个正序数组的中位数
 */
public class Lc0004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length, n = nums2.length, k = (m + n + 1) / 2;
        int[] a = new int[m + 2];
        int[] b = new int[n + 2];
        a[0] = b[0] = Integer.MIN_VALUE;
        a[m + 1] = b[n + 1] = Integer.MAX_VALUE;
        System.arraycopy(nums1, 0, a, 1, m);
        System.arraycopy(nums2, 0, b, 1, n);
        int l = 0, r = m, mid;
        int leftA = 0, leftB = k;
        while (l <= r) {
            mid = l + (r - l) / 2;
            // a 中左边的个数
            leftA = mid;
            // b 中左边的个数
            leftB = k - leftA;
            // 左边的最大值小于右边的最大值直接跳出循环
            if (Math.max(a[leftA], b[leftB]) <= Math.min(a[leftA + 1], b[leftB + 1])) {
                break;
            }
            // 否则如果 a 的大，就说明a中个数多了，缩小个数
            if (a[leftA] > b[leftB]) {
                r = mid - 1;
            } else {
                // 相反如果 a 的小，就说明a中个数少了，扩大个数
                l = mid + 1;
            }
        }
        if (((m + n) & 1) == 1) {
            return Math.max(a[leftA], b[leftB]);
        }
        return (Math.max(a[leftA], b[leftB]) + Math.min(a[leftA + 1], b[leftB + 1])) / 2.0;
    }
}
