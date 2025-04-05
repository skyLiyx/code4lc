package lyx.lc.c3;

/**
 * 350. 两个数组的交集 II
 */
public class Lc0350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] count = new int[1001];
        for (int i : nums1) {
            count[i]++;
        }
        int[] intersect = new int[1001];
        int index = 0;
        for (int i : nums2) {
            if (count[i]-- > 0) {
                intersect[index++] = i;
            }
        }
        int[] ans = new int[index];
        System.arraycopy(intersect, 0, ans, 0, index);
        return ans;
    }
}
