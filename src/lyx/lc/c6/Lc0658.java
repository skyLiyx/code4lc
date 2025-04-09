package lyx.lc.c6;

import java.util.ArrayList;
import java.util.List;

/**
 * 658. 找到 K 个最接近的元素
 */
public class Lc0658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        int l = 0, r = arr.length - 1, m;
        int index = -1; // 找不小于x的最左边的数
        while (l <= r) {
            m = l + (r - l) / 2;
            if (arr[m] >= x) {
                index = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        // 当前位置 >= x, 再判断左边一个数字是否更接近
        if (index > 0 && x - arr[index - 1] <= arr[index] - x) {
            index--;
        }
        // 没找到, 说明数组中的数全部小于x
        if (index == -1) {
            for (int i = arr.length - k; i < arr.length; i++) {
                ans.add(arr[i]);
            }
            return ans;
        }
        l = r = index;
        // 以此为中心往左右两边扩
        while (r - l + 1 < k) {
            while (r - l + 1 < k && l - 1 >= 0 && (r == arr.length - 1 || x - arr[l - 1] <= arr[r + 1] - x)) {
                l--;
            }
            while (r - l + 1 < k && r + 1 < arr.length && (l == 0 || x - arr[l - 1] > arr[r + 1] - x)) {
                r++;
            }
        }
        for (int i = l; i <= r; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }
}
