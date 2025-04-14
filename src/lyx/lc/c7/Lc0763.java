package lyx.lc.c7;

import java.util.ArrayList;
import java.util.List;

/**
 * 763. 划分字母区间
 */
public class Lc0763 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        char[] arr = s.toCharArray();
        int[] rightestPos = new int[26];  // 每个字母最右侧的位置
        for (int i = 0; i < arr.length; i++) {
            rightestPos[arr[i] - 'a'] = i;
        }
        int left = -1, right = -1;
        for (int i = 0; i < arr.length; i++) {
            int rightest = rightestPos[arr[i] - 'a'];
            if (rightest < right) {
                continue;
            }
            if (i > right) {
                // 初始 或 上段结束了
                right = rightest;
            }
            if (i < right && rightest > right) {
                // 本段还没结束，遇到更远的
                right = rightest;
            }
            if (i == right) {
                // 本段结束
                ans.add(right - left);
                left = i;
            }
        }
        return ans;
    }
}
