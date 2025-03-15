package com.lynx.lc.c4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 421.数组中两个数的最大异或值
 */
public class Lc0421 {
    public int findMaximumXOR(int[] nums) {
        int ans = 0;
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        Set<Integer> set = new HashSet<>();
        // 逐位确定最大的值
        for (int i = 31 - Integer.numberOfLeadingZeros(max); i >= 0; i--) {
            // 当前位的最大值
            int better = ans | (1 << i);
            set.clear();
            for (int num : nums) {
                // 移除掉i后面的0
                num = (num >> i) << i;
                set.add(num);
                if (set.contains(better ^ num)) {
                    // 存在一个数和当前数字异或后等于better
                    ans = better;
                    break;
                }
            }
        }
        return ans;
    }

    /**
     * 前缀树版本。
     */
    public int findMaximumXOR_v1(int[] nums) {
        build(nums);
        int ans = 0;
        for (int num : nums) {
            ans = Math.max(ans, getXor(num));
        }
        clear();
        return ans;
    }

    private int high;

    private final int max = 3000001;

    private final int[][] tree = new int[max][2];

    private int cnt;

    private void build(int[] nums) {
        cnt = 1;
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        high = 31 - Integer.numberOfLeadingZeros(max);
        for (int num : nums) {
            insert(num);
        }
    }

    private void insert(int n) {
        int cur = 1;
        for (int i = high, path; i >= 0; i--) {
            path = (n >> i) & 1;
            if (tree[cur][path] == 0) {
                tree[cur][path] = ++cnt;
            }
            cur = tree[cur][path];
        }
    }

    private int getXor(int num) {
        int ans = 0;
        int cur = 1;
        for (int i = high, status, want; i >= 0; i--) {
            // 当前位的状态
            status = (num >> i) & 1;
            // 结果尽可能大想要的状态
            want = status ^ 1;
            // 从前缀树中找，如果没有，取另一个
            if (tree[cur][want] == 0) {
                want = status;
            }
            ans |= (status ^ want) << i;
            cur = tree[cur][want];
        }
        return ans;
    }

    private void clear() {
        for (int i = cnt; i >= 0; i--) {
            Arrays.fill(tree[cnt], 0);
        }
    }
}
