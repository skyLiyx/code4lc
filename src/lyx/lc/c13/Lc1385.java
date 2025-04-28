package lyx.lc.c13;

import java.util.Arrays;

/**
 * 1385. 两个数组间的距离值
 */
public class Lc1385 {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans = 0;
        int n = arr2.length;
        Arrays.sort(arr2);
        for (int a : arr1) {
            // 找出大于a+d的最左位置
            int p1 = binarySearch1(arr2, a + d + 1);
            // 找出小于a-d的最右位置
            int p2 = binarySearch2(arr2, a - d - 1);
            if (p1 == -1) {
                if (p2 == n - 1) {
                    ans++;
                }
            } else if (p2 == -1) {
                if (p1 == 0) {
                    ans++;
                }
            } else {
                if (p1 == p2 + 1) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private int binarySearch1(int[] arr, int i) {
        int l = 0, r = arr.length - 1, m;
        int ans = -1;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (arr[m] >= i) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

    private int binarySearch2(int[] arr, int i) {
        int l = 0, r = arr.length - 1, m;
        int ans = -1;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (arr[m] <= i) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }
}
